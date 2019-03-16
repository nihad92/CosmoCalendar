package com.applikeysolutions.cosmocalendar.view.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.applikeysolutions.cosmocalendar.adapter.viewholder.DisabledDayHolder;
import com.applikeysolutions.cosmocalendar.model.Day;
import com.applikeysolutions.cosmocalendar.view.CalendarView;
import com.applikeysolutions.customizablecalendar.R;

public class DisabledDayDelegate {

  private CalendarView calendarView;

  public DisabledDayDelegate(CalendarView calendarView) {
    this.calendarView = calendarView;
  }

  public DisabledDayHolder onCreateDayHolder(ViewGroup parent, int viewType) {
    final View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.view_disabled_day, parent, false);
    return new DisabledDayHolder(view, calendarView);
  }

  public void onBindDayHolder(Day day, DisabledDayHolder holder, int position) {
    holder.bind(day);
  }
}
