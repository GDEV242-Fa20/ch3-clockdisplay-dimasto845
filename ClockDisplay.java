
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display

    // Constructor for ClockDisplay objects.
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    // Constructor for ClockDisplay objects.
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }
  
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) { // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

  
    

    //Set the time of the display to the specified hour and minute.
   
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    // Return the current time of this display in the format HH:MM.
   
    public String getTime()
    {
        return displayString;
    }

    // Update the internal string that represents the display.
   
    private void updateDisplay()
    {
        int hour = hours.getValue();
        String AmPm;

        if( hour >= 12) {
            AmPm= "PM";
        }
        else {
            AmPm= "AM";
        }

        if (hour >= 12) {
            hour -= 12;
        }

        if (hour == 00) {
            hour = 12;
        }

        displayString = hour + ":" + minutes.getDisplayValue() + "."+AmPm;
    }
}