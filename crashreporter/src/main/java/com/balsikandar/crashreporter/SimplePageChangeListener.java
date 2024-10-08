package com.balsikandar.crashreporter;

import androidx.viewpager.widget.ViewPager;

/** Created by bali on 11/08/17. */
abstract class SimplePageChangeListener implements ViewPager.OnPageChangeListener {
  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

  @Override
  public abstract void onPageSelected(int position);

  @Override
  public void onPageScrollStateChanged(int state) {}
}
