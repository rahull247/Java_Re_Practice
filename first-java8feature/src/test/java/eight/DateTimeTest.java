package eight;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class DateTimeTest {

    @Test
    void first_dateTimeNow() {
        System.out.println("Date: " + LocalDate.now());
        System.out.println("Time: " + LocalTime.now());
        System.out.println("Date Time: " + LocalDateTime.now());
    }

    @Test
    void second_localDate() {
        LocalDate integerMonthOf = LocalDate.of(2023, 1, 15);
        LocalDate StringMonthOf = LocalDate.of(2023, Month.JANUARY, 15);

        System.out.println(integerMonthOf);
        System.out.println(StringMonthOf);
    }

    private LocalDate getDate() {
        return LocalDate.of(2022, 3, 27);
    }

    @Test
    void third_extractInfoFromLocalDate() {
        LocalDate date = getDate();
        System.out.println("getYear(): " + date.getYear());
        System.out.println("getMonth(): " + date.getMonth());
        System.out.println("getDayOfMonth(): " + date.getDayOfMonth());
        System.out.println("getDayOfWeek(): " + date.getDayOfWeek());
        System.out.println("getDayOfYear(): " + date.getDayOfYear());
        System.out.println("lengthOfMonth(): " + date.lengthOfMonth());
        System.out.println("lengthOfYear(): " + date.lengthOfYear());
        System.out.println("isLeapYear(): " + date.isLeapYear());
    }

    private LocalTime getTime() {
        return LocalTime.of(12, 52, 34, 5677);
    }

    @Test
    void fourth_extractInfoFromLocalTime() {
        LocalTime time = getTime();
        System.out.println("getHour(): " + time.getHour());
        System.out.println("getMinute(): " + time.getMinute());
        System.out.println("getSecond(): " + time.getSecond());
        System.out.println("getNano(): " + time.getNano());

    }

    @Test
    void fifth_extractInfoFromLocalDateUsingChronoField() {
        LocalDate date = getDate();
        int year = date.get(ChronoField.YEAR);
        int monthOfYear = date.get(ChronoField.MONTH_OF_YEAR);
        int dayOfMonth = date.get(ChronoField.DAY_OF_MONTH);
        int dayOfWeek = date.get(ChronoField.DAY_OF_WEEK);
        int dayOfYear = date.get(ChronoField.DAY_OF_YEAR);
        System.out.println(year);
        System.out.println(monthOfYear);
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);
        System.out.println(dayOfYear);

    }

    @Test
    void sixth_dateOrTimeStringParse() {
        LocalDate parseDate = LocalDate.parse("2022-10-04");
        LocalTime parseTime = LocalTime.parse("13:32:45");
        System.out.println(parseDate);
        System.out.println(parseTime);
        System.out.println(parseDate.getYear() + "/" + parseDate.getMonth() + "/" + parseDate.getDayOfMonth());
        System.out.println(parseTime.getHour() + ":" + parseTime.getMinute() + ":" + parseTime.getSecond());

    }

    @Test
    void seven_getLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 12, 22, 14, 56, 34, 798);
        System.out.println(localDateTime);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());
    }

    @Test
    void eight_Instant() {
        System.out.println(Instant.now()); //UTC Current Time
        System.out.println(Instant.ofEpochSecond(3));
    }

    @Test
    void nine_convertInstantUTCToClock() {
        Instant now = Instant.now();
        Clock fixed = Clock.fixed(now, ZoneId.of("America/New_York"));
        System.out.println(fixed);
    }
    @Test
    void ten_duration() {
        //Duration is use for time comparison
        LocalDateTime prev = LocalDateTime.of(2022, 12, 22, 14, 56, 34, 798);
        LocalDateTime now=LocalDateTime.now();

        System.out.println(Duration.between(prev, now));
        System.out.println(Duration.between(LocalTime.of(13, 59, 00), LocalTime.of(14, 59, 00)));


    }
    @Test
    void eleven_period() {
        //Period is use for date comparison
        LocalDateTime prev = LocalDateTime.of(2022, 12, 22, 14, 56, 34, 798);
        LocalDateTime now=LocalDateTime.now();

        System.out.println(Period.between(prev.toLocalDate(), now.toLocalDate()));
        System.out.println(Period.between(LocalDate.of(2022, 12,01), LocalDate.of(2023,04,14)));



    }
    @Test
    void tweleve_periodAndDuration() {
        System.out.println(Duration.ofMinutes(4));
        System.out.println(Duration.of(4, ChronoUnit.MINUTES));

        System.out.println(Period.ofDays(14));
        System.out.println(Period.ofMonths(10));
        System.out.println(Period.ofWeeks(54));
        System.out.println(Period.ofYears(5));
    }

    @Test
    void thirteen_zoneBasedDateTime(){
        ZoneId romeTimeZone = ZoneId.of("Europe/Rome");//Area/city
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println(romeTimeZone);
        System.out.println(zoneId);
    }
    @Test
    void fourteen_zoneDateTime(){
        ZoneId romeTimeZone = ZoneId.of("Europe/Rome");//Area/city
        LocalDate localDate = LocalDate.of(2022, Month.APRIL, 28);
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.APRIL, 28, 15, 44, 12);
        System.out.println(localDate.atStartOfDay(romeTimeZone));
        System.out.println(localDateTime.atZone(romeTimeZone));
    }

    @Test
    void fifteen_offsetDateTime(){
        //2022-04-28T15:44:12+02:00[Europe/Rome]
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.JANUARY, 28, 18, 13, 45);
        System.out.println(OffsetDateTime.of(localDateTime, ZoneOffset.of("05.00")));
    }
    @Test
    void sixteen_localDateAndTimeWithFormat(){
        //2022-04-28T15:44:12+02:00[Europe/Rome]
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy:HH:mm:SS")));
    }

}
