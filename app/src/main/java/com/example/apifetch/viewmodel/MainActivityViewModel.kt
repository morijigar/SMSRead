package com.example.apifetch.viewmodel

import android.app.Activity
import android.database.Cursor
import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apifetch.models.ApiResponse
import com.example.apifetch.models.Sms
import com.example.apifetch.util.SingletoneData
import com.example.myapplication.ws.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivityViewModel : ViewModel() {

    var fetchingSms = MutableLiveData<Boolean>()

    private val repository: Repository = Repository()

    public fun readSMS(activity: Activity): MutableList<Sms> {
        val lstSms = mutableListOf<Sms>()
        viewModelScope.launch(Dispatchers.IO) {
            fetchingSms.postValue(true)
            SingletoneData.incomeArr.clear()
            SingletoneData.expanseArr.clear()
            SingletoneData.totalExpanse = 0.0
            SingletoneData.totalIncome = 0.0
            val INBOX_URI = "content://sms/inbox"
            val mSmsQueryUri = Uri.parse(INBOX_URI)
            var cursor: Cursor? = null
            try {
                cursor = activity.contentResolver.query(
                    mSmsQueryUri,
                    null, null, null, null
                )
                if (cursor == null) {
                    Log.i("TAG", "cursor is null. uri: $mSmsQueryUri")
                }
                var hasData: Boolean = cursor!!.moveToFirst()
                while (hasData) {
                    val objSms = Sms()
                    objSms.setId(cursor.getString(cursor.getColumnIndexOrThrow("_id")));
                    objSms.setAddress(
                        cursor.getString(
                            cursor
                                .getColumnIndexOrThrow("address")
                        )
                    );
                    val msgData = cursor.getString(cursor.getColumnIndexOrThrow("body"))
                    objSms.setMsg(msgData);
                    objSms.setReadState(cursor.getString(cursor.getColumnIndex("read")));
                    objSms.setTime(cursor.getString(cursor.getColumnIndexOrThrow("date")));
                    if (cursor.getString(cursor.getColumnIndexOrThrow("type")).contains("1")) {
                        objSms.setFolderName("inbox");
                    } else {
                        objSms.setFolderName("sent");
                    }
                    //received,credited  spent,debited,withdrawn
                    if (msgData.contains("credited") or msgData.contains("received")) {
                        incomeMsg(objSms)
                    } else if (msgData.contains("spent") or msgData.contains("debited") or msgData.contains(
                            "withdrawn"
                        )
                    ) {
                        expanseMsg(objSms)
                    }

                    lstSms.add(objSms);
                    hasData = cursor!!.moveToNext()
                }
            } catch (e: Exception) {
                Log.e("TAG", e.message)
            } finally {
                cursor?.close()
            }
            fetchingSms.postValue(false)
        }

        return lstSms
    }

    fun incomeMsg(sms: Sms) {

        val amount = findAmount(sms.msg)
        sms._amount = amount
        val amountD = fetchAmountFromString(amount)
        sms.amountD = amountD

        SingletoneData.totalIncome += amountD

        SingletoneData.incomeArr.add(sms)

    }

    fun expanseMsg(sms: Sms) {

        val amount = findAmount(sms.msg)
        sms._amount = amount
        val amountD = fetchAmountFromString(amount)
        sms.amountD = amountD

        SingletoneData.totalExpanse += amountD

        SingletoneData.expanseArr.add(sms)

    }

    fun findAmount(textToUse: String): String {
        val regexAmount = "(?i)(?:(?:RS|INR|MRP)\\.?\\s?)(\\d+(:?\\,\\d+)?(\\,\\d+)?(\\.\\d{1,2})?)"
        var amount = "0.0";
        val pattern: Pattern = Pattern.compile(regexAmount)
        val matcher: Matcher = pattern.matcher(textToUse)
        if (matcher.find()) {
            amount = textToUse.substring(matcher.start(), matcher.end())
        }

        return amount
    }

    fun fetchAmountFromString(textToUse: String): Double {
        //val regex = "^[^\\d]*(\\d+|\\d+((,|\\.)\\d{1,2}))(\\s|[a-zA-Z)]|€|\$).*"
        val regex = "([0-9]+[, .]?)+"
        val price = 0.0
        var amount = "0.0";
        val pattern: Pattern = Pattern.compile(regex)
        val matcher: Matcher = pattern.matcher(textToUse)
        if (matcher.find()) {
            amount = textToUse.substring(matcher.start(), matcher.end())
        }

        return amount.toDouble()
       /* if (textToUse.contains("RS")) {

        } else if (textToUse.contains("RS.")) {

        }else if (textToUse.contains("INR.")) {

        }*/

    }


}