package com.applikeysolutions.cosmocalendar.adapter.viewholder;

import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.applikeysolutions.cosmocalendar.model.Day;
import com.applikeysolutions.cosmocalendar.view.CalendarView;
import com.applikeysolutions.customizablecalendar.R;

public class DisabledDayHolder extends BaseDayHolder {

  public DisabledDayHolder(View itemView, CalendarView calendarView) {
    super(itemView, calendarView);
    tvDay = (TextView) itemView.findViewById(R.id.tv_day_number);
  }

  public void bind(Day day) {
    tvDay.setText(String.valueOf(day.getDayNumber()));
    tvDay.setTextColor(calendarView.getDisabledDayTextColor());
    tvDay.setTextSize(TypedValue.COMPLEX_UNIT_PX, calendarView.getDayTextSize());
  }
}
