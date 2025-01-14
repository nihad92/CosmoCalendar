package com.applikeysolutions.cosmocalendar.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applikeysolutions.cosmocalendar.model.Day;
import com.applikeysolutions.cosmocalendar.model.Month;
import com.applikeysolutions.cosmocalendar.settings.appearance.AppearanceInterface;
import com.applikeysolutions.cosmocalendar.settings.date.DateInterface;
import com.applikeysolutions.cosmocalendar.settings.lists.CalendarListsInterface;
import com.applikeysolutions.cosmocalendar.settings.lists.DisabledDaysCriteria;
import com.applikeysolutions.cosmocalendar.settings.lists.connected_days.ConnectedDays;
import com.applikeysolutions.cosmocalendar.settings.lists.connected_days.ConnectedDaysManager;
import com.applikeysolutions.cosmocalendar.settings.selection.SelectionInterface;
import com.applikeysolutions.cosmocalendar.utils.SelectionType;
import com.applikeysolutions.cosmocalendar.view.CalendarView;
import com.applikeysolutions.customizablecalendar.R;
import java.util.List;
import java.util.Set;

public class CalendarDialog extends Dialog implements View.OnClickListener,
    AppearanceInterface, DateInterface, CalendarListsInterface, SelectionInterface {

  //Views
  private FrameLayout flNavigationButtonsBar;
  private ImageView ivCancel;
  private ImageView ivDone;
  private CalendarView calendarView;

  private OnDaysSelectionListener onDaysSelectionListener;

  public CalendarDialog(@NonNull Context context) {
    super(context);
  }

  public CalendarDialog(@NonNull Context context, OnDaysSelectionListener onDaysSelectionListener) {
    super(context);
    this.onDaysSelectionListener = onDaysSelectionListener;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);

    setContentView(R.layout.dialog_calendar);
    getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    getWindow().getAttributes().gravity = Gravity.TOP;

    initViews();
  }

  private void initViews() {
    flNavigationButtonsBar = (FrameLayout) findViewById(R.id.fl_navigation_buttons_bar);
    ivCancel = (ImageView) findViewById(R.id.iv_cancel);
    ivDone = (ImageView) findViewById(R.id.iv_done);
    calendarView = (CalendarView) findViewById(R.id.calendar_view);

    Drawable background = calendarView.getBackground();

    if (background instanceof ColorDrawable) {
      flNavigationButtonsBar.setBackgroundColor(((ColorDrawable) background).getColor());
    }

    ivCancel.setOnClickListener(this);
    ivDone.setOnClickListener(this);
  }

  public void setOnDaysSelectionListener(OnDaysSelectionListener onDaysSelectionListener) {
    this.onDaysSelectionListener = onDaysSelectionListener;
  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.iv_cancel) {
      cancel();
    } else if (id == R.id.iv_done) {
      doneClick();
    }
  }

  private void doneClick() {
    List<Day> selectedDays = calendarView.getSelectedDays();
    if (onDaysSelectionListener != null) {
      onDaysSelectionListener.onDaysSelected(selectedDays);
    }
    dismiss();
  }

  @Override
  @SelectionType
  public int getSelectionType() {
    return calendarView.getSelectionType();
  }

  @Override
  public void setSelectionType(@SelectionType int selectionType) {
    calendarView.setSelectionType(selectionType);
  }

  @Override
  public int getCalendarBackgroundColor() {
    return calendarView.getCalendarBackgroundColor();
  }

  @Override
  public void setCalendarBackgroundColor(int calendarBackgroundColor) {
    calendarView.setCalendarBackgroundColor(calendarBackgroundColor);
  }

  @Override
  public int getMonthTextColor() {
    return calendarView.getMonthTextColor();
  }

  @Override
  public void setMonthTextColor(int monthTextColor) {
    calendarView.setMonthTextColor(monthTextColor);
  }

  @Override
  public int getOtherDayTextColor() {
    return calendarView.getOtherDayTextColor();
  }

  @Override
  public void setOtherDayTextColor(int otherDayTextColor) {
    calendarView.setOtherDayTextColor(otherDayTextColor);
  }

  @Override
  public int getDayTextColor() {
    return calendarView.getDayTextColor();
  }

  @Override
  public void setDayTextColor(int dayTextColor) {
    calendarView.setDayTextColor(dayTextColor);
  }

  @Override
  public int getWeekendDayTextColor() {
    return calendarView.getWeekendDayTextColor();
  }

  @Override
  public void setWeekendDayTextColor(int weekendDayTextColor) {
    calendarView.setWeekendDayTextColor(weekendDayTextColor);
  }

  @Override
  public int getWeekDayTitleTextColor() {
    return calendarView.getWeekDayTitleTextColor();
  }

  @Override
  public void setWeekDayTitleTextColor(int weekDayTitleTextColor) {
    calendarView.setWeekDayTitleTextColor(weekDayTitleTextColor);
  }

  @Override
  public int getSelectedDayTextColor() {
    return calendarView.getSelectedDayTextColor();
  }

  @Override
  public void setSelectedDayTextColor(int selectedDayTextColor) {
    calendarView.setSelectedDayTextColor(selectedDayTextColor);
  }

  @Override
  public int getSelectedDayBackgroundColor() {
    return calendarView.getSelectedDayBackgroundColor();
  }

  @Override
  public void setSelectedDayBackgroundColor(int selectedDayBackgroundColor) {
    calendarView.setSelectedDayBackgroundColor(selectedDayBackgroundColor);
  }

  @Override
  public int getSelectedDayBackgroundStartColor() {
    return calendarView.getSelectedDayBackgroundStartColor();
  }

  @Override
  public void setSelectedDayBackgroundStartColor(int selectedDayBackgroundStartColor) {
    calendarView.setSelectedDayBackgroundStartColor(selectedDayBackgroundStartColor);
  }

  @Override
  public int getSelectedDayBackgroundEndColor() {
    return calendarView.getSelectedDayBackgroundEndColor();
  }

  @Override
  public void setSelectedDayBackgroundEndColor(int selectedDayBackgroundEndColor) {
    calendarView.setSelectedDayBackgroundEndColor(selectedDayBackgroundEndColor);
  }

  @Override
  public int getCurrentDayTextColor() {
    return calendarView.getCurrentDayTextColor();
  }

  @Override
  public void setCurrentDayTextColor(int currentDayTextColor) {
    calendarView.setCurrentDayTextColor(currentDayTextColor);
  }

  @Override
  public int getCurrentDayIconRes() {
    return calendarView.getCurrentDayIconRes();
  }

  @Override
  public void setCurrentDayIconRes(int currentDayIconRes) {
    calendarView.setCurrentDayIconRes(currentDayIconRes);
  }

  @Override
  public int getCurrentDaySelectedIconRes() {
    return calendarView.getCurrentDaySelectedIconRes();
  }

  @Override
  public void setCurrentDaySelectedIconRes(int currentDaySelectedIconRes) {
    calendarView.setCurrentDaySelectedIconRes(currentDaySelectedIconRes);
  }

  @Override
  public int getCalendarOrientation() {
    return calendarView.getCalendarOrientation();
  }

  @Override
  public void setCalendarOrientation(int calendarOrientation) {
    calendarView.setCalendarOrientation(calendarOrientation);
  }

  @Override
  public int getConnectedDayIconRes() {
    return calendarView.getConnectedDayIconRes();
  }

  @Override
  public void setConnectedDayIconRes(int connectedDayIconRes) {
    calendarView.setConnectedDayIconRes(connectedDayIconRes);
  }

  @Override
  public int getConnectedDaySelectedIconRes() {
    return calendarView.getConnectedDaySelectedIconRes();
  }

  @Override
  public void setConnectedDaySelectedIconRes(int connectedDaySelectedIconRes) {
    calendarView.setConnectedDaySelectedIconRes(connectedDaySelectedIconRes);
  }

  @Override
  public int getConnectedDayIconPosition() {
    return calendarView.getConnectedDayIconPosition();
  }

  @Override
  public void setConnectedDayIconPosition(int connectedDayIconPosition) {
    calendarView.setConnectedDayIconPosition(connectedDayIconPosition);
  }

  @Override
  public int getDisabledDayTextColor() {
    return calendarView.getDisabledDayTextColor();
  }

  @Override
  public void setDisabledDayTextColor(int disabledDayTextColor) {
    calendarView.setDisabledDayTextColor(disabledDayTextColor);
  }

  @Override
  public int getSelectionBarMonthTextColor() {
    return calendarView.getSelectionBarMonthTextColor();
  }

  @Override
  public void setSelectionBarMonthTextColor(int selectionBarMonthTextColor) {
    calendarView.setSelectionBarMonthTextColor(selectionBarMonthTextColor);
  }

  @Override
  public int getPreviousMonthIconRes() {
    return calendarView.getPreviousMonthIconRes();
  }

  @Override
  public void setPreviousMonthIconRes(int previousMonthIconRes) {
    calendarView.setPreviousMonthIconRes(previousMonthIconRes);
  }

  @Override
  public int getNextMonthIconRes() {
    return calendarView.getNextMonthIconRes();
  }

  @Override
  public void setNextMonthIconRes(int nextMonthIconRes) {
    calendarView.setNextMonthIconRes(nextMonthIconRes);
  }

  @Override
  public boolean isShowDaysOfWeek() {
    return calendarView.isShowDaysOfWeek();
  }

  @Override
  public void setShowDaysOfWeek(boolean showDaysOfWeek) {
    calendarView.setShowDaysOfWeek(showDaysOfWeek);
  }

  @Override
  public boolean isShowDaysOfWeekTitle() {
    return calendarView.isShowDaysOfWeekTitle();
  }

  @Override
  public void setShowDaysOfWeekTitle(boolean showDaysOfWeekTitle) {
    calendarView.setShowDaysOfWeekTitle(showDaysOfWeekTitle);
  }

  @Override public void setWeekDayTitleTextSize(float weekDayTitleTextSize) {
    calendarView.setWeekDayTitleTextSize(weekDayTitleTextSize);
  }

  @Override public float getWeekDayTitleTextSize() {
    return calendarView.getWeekDayTitleTextSize();
  }

  @Override public void setMonthTextSize(float monthTextSize) {
    calendarView.setMonthTextSize(monthTextSize);
  }

  @Override public float getMonthTextSize() {
    return calendarView.getMonthTextSize();
  }

  @Override public void setDayTextSize(float dayTextSize) {
    calendarView.setDayTextSize(dayTextSize);
  }

  @Override public float getDayTextSize() {
    return calendarView.getDayTextSize();
  }

  @Override public float getSelectedDayTextSize() {
    return calendarView.getSelectedDayTextSize();
  }

  @Override public void setSelectedDayTextSize(float selectedDayTextSize) {
    calendarView.setSelectedDayTextSize(selectedDayTextSize);
  }

  @Override
  public Set<Long> getDisabledDays() {
    return calendarView.getDisabledDays();
  }

  @Override
  public void setDisabledDays(Set<Long> disabledDays) {
    calendarView.setDisabledDays(disabledDays);
  }

  @Override public Set<Integer> getMonthDisabledDays(Month month) {
    return calendarView.getMonthDisabledDays(month);
  }

  @Override public void setMonthDisabledDays(Month month, Set<Integer> disabledDays) {
    calendarView.setMonthDisabledDays(month, disabledDays);
  }

  @Override
  public ConnectedDaysManager getConnectedDaysManager() {
    return calendarView.getConnectedDaysManager();
  }

  @Override
  public Set<Long> getWeekendDays() {
    return calendarView.getWeekendDays();
  }

  @Override
  public void setWeekendDays(Set<Long> weekendDays) {
    calendarView.setWeekendDays(weekendDays);
  }

  @Override
  public DisabledDaysCriteria getDisabledDaysCriteria() {
    return calendarView.getDisabledDaysCriteria();
  }

  @Override
  public void setDisabledDaysCriteria(DisabledDaysCriteria criteria) {
    calendarView.setDisabledDaysCriteria(criteria);
  }

  @Override
  public void addConnectedDays(ConnectedDays connectedDays) {
    calendarView.addConnectedDays(connectedDays);
  }

  @Override
  public int getFirstDayOfWeek() {
    return calendarView.getFirstDayOfWeek();
  }

  @Override
  public void setFirstDayOfWeek(int firstDayOfWeek) {
    calendarView.setFirstDayOfWeek(firstDayOfWeek);
  }
}
