package com.applikeysolutions.cosmocalendar.settings.lists;

import com.applikeysolutions.cosmocalendar.model.Month;
import com.applikeysolutions.cosmocalendar.settings.lists.connected_days.ConnectedDays;
import com.applikeysolutions.cosmocalendar.settings.lists.connected_days.ConnectedDaysManager;
import java.util.Set;

public interface CalendarListsInterface {

  Set<Long> getDisabledDays();

  void setDisabledDays(Set<Long> disabledDays);

  Set<Integer> getMonthDisabledDays(Month month);

  void setMonthDisabledDays(
      Month month, Set<Integer> disabledDays);

  ConnectedDaysManager getConnectedDaysManager();

  Set<Long> getWeekendDays();

  void setWeekendDays(Set<Long> weekendDays);

  DisabledDaysCriteria getDisabledDaysCriteria();

  void setDisabledDaysCriteria(DisabledDaysCriteria criteria);

  void addConnectedDays(ConnectedDays connectedDays);
}
