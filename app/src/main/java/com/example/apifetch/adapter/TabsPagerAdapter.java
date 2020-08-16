package com.example.apifetch.adapter;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.apifetch.R;
import com.example.apifetch.fragment.ChartFragment;
import com.example.apifetch.fragment.ExpanseFragment;
import com.example.apifetch.fragment.IncomeFragment;
import com.example.apifetch.fragment.MainFragment;

//Need Replace with viewpager 2
public class TabsPagerAdapter extends FragmentPagerAdapter {
  @StringRes
  private static final int[] TAB_TITLES =
      new int[] { R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3 };
  private final Context mContext;
  public TabsPagerAdapter(Context context, FragmentManager fm) {
    super(fm);
    mContext = context;
  }
  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return IncomeFragment.newInstance("","");
      case 1:
        return ExpanseFragment.newInstance("","");
      case 2:
        return ChartFragment.newInstance("","");
      default:
        return null;
    }
  }
  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return mContext.getResources().getString(TAB_TITLES[position]);
  }
  @Override
  public int getCount() {
    // Show 3 total pages.
    return 3;
  }
}