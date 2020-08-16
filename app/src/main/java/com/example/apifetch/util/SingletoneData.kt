package com.example.apifetch.util

import com.example.apifetch.models.Sms

object SingletoneData {

    var incomeArr = mutableListOf<Sms>()
    var expanseArr = mutableListOf<Sms>()

    var totalExpanse = 0.0
    var totalIncome = 0.0
}