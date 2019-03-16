package com.applikeysolutions.cosmocalendar.settings.lists;

import com.applikeysolutions.cosmocalendar.model.Month;
import com.applikeysolutions.cosmocalendar.settings.lists.connected_days.ConnectedDays;
import com.applikeysolutions.cosmocalendar.settings.lists.connected_days.ConnectedDaysManager;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CalendarListsModel implements CalendarListsInterface {

  //Disabled days cannot be selected
  private Set<Long> disabledDays = new TreeSet<>();

  private Map<Month,Set<Integer>> monthDisabledDays = new HashMap<>();

  private DisabledDaysCriteria disabledDaysCriteria;

  //Custom connected days for displaying in calendar
  private ConnectedDaysManager connectedDaysManager = ConnectedDaysManager.getInstance();

  private Set<Long> weekendDays = new HashSet() {{
    add(Calendar.SUNDAY);
  }};

  @Override
  public Set<Long> getDisabledDays() {
    return disabledDays;
  }

  @Override
  public void setDisabledDays(Set<Long> disabledDays) {
    this.disabledDays = disabledDays;
  }

  @Override
  public Set<Integer> getMonthDisabledDays(Month month) {
    return monthDisabledDays.get(month);
  }

  @Override
  public void setMonthDisabledDays(
      Month month, Set<Integer> disabledDays) {
    if (monthDisabledDays.containsKey(month)) {
      monthDisabledDays.get(month).addAll(disabledDays);
    } else {
      monthDisabledDays.put(month, disabledDays);
    }
  }

  @Override
  public ConnectedDaysManager getConnectedDaysManager() {
    return connectedDaysManager;
  }

  @Override
  public Set<Long> getWeekendDays() {
    return weekendDays;
  }

  @Override
  public void setWeekendDays(Set<Long> weekendDays) {
    this.weekendDays = weekendDays;
  }

  @Override
  public DisabledDaysCriteria getDisabledDaysCriteria() {
    return disabledDaysCriteria;
  }

  @Override
  public void setDisabledDaysCriteria(DisabledDaysCriteria criteria) {
    this.disabledDaysCriteria = criteria;
  }

  @Override
  public void addConnectedDays(ConnectedDays connectedDays) {
    connectedDaysManager.addConnectedDays(connectedDays);
  }
}
