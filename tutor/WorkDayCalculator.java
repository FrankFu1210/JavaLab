package tw.frank.tutor;
import java.time.DayOfWeek;
import java.time.LocalDate;
public class WorkDayCalculator {
		    public static LocalDate addWorkDays(LocalDate date, int days) {
		        int addedDays = 0;
		        while (addedDays < days) {
		            date = date.plusDays(1);
		            if (isWorkDay(date)) {
		                addedDays++;
		            }
		        }
		        return date;
		    }

		    private static boolean isWorkDay(LocalDate date) {
		        DayOfWeek dayOfWeek = date.getDayOfWeek();
		        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
		    }
		}

//-----------------------------------
//©著作权归作者所有：来自51CTO博客作者mob649e815ddfb8的原创作品，请联系作者获取转载授权，否则将追究法律责任
//java给日期加工作日
//https://blog.51cto.com/u_16175473/6917314
