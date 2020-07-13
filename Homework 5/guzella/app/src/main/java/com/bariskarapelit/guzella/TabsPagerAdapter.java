package com.bariskarapelit.guzella;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter
{
    static int[] TAB_TITLES = new int[]{R.string.tab_text_1,R.string.tab_text_2,R.string.tab_text_3,
    R.string.tab_text_4,R.string.tab_text_5};

    Context mContext;


    public TabsPagerAdapter(Context context, FragmentManager fm)
    {
        super(fm);
        mContext=context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return main.newInstance();
            case 1:
                return seacrh.newInstance();
            case 2:
                return  sepet.newInstance();
            case 3:
                return hesabim.newInstance();
            case 4:
                return diger.newInstance();
            default:
                return null;

        }
    }
    @NonNull
    @Override
    public CharSequence getPageTitle(int position)
    {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount()
    {
        return 5;
    }
}
