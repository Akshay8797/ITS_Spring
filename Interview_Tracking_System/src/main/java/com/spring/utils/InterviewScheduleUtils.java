package com.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.spring.entity.ITS_TBL_Interview_Schedule_Entity;
import com.spring.json.ITS_TBL_Interview_Schedule;

public class InterviewScheduleUtils {

		public static List<ITS_TBL_Interview_Schedule> convertScheduleEntityListToScheduleList(List<ITS_TBL_Interview_Schedule_Entity> scheduleEntityList) {
			List<ITS_TBL_Interview_Schedule> scheduleList = new ArrayList<ITS_TBL_Interview_Schedule>();
			Consumer<ITS_TBL_Interview_Schedule_Entity> consumer = (ITS_TBL_Interview_Schedule_Entity scheduleEntity)->scheduleList.add(convertScheduleEntityToSchedule(scheduleEntity));
			scheduleEntityList.stream().forEach(consumer);
			return scheduleList;
		}
		
		public static ITS_TBL_Interview_Schedule convertScheduleEntityToSchedule(ITS_TBL_Interview_Schedule_Entity scheduleEntity) {
			return new ITS_TBL_Interview_Schedule(scheduleEntity.getInterviewId(),scheduleEntity.getSubject(),scheduleEntity.getInterviewDate(),
					scheduleEntity.getInterviewTime(),scheduleEntity.getTechRating(),scheduleEntity.getEmpHRInterviewDate(),scheduleEntity.getEmpHRInterviewTime()
					,scheduleEntity.getEmpHRRating(),scheduleEntity.getResult(),scheduleEntity.getShareResult());
		}

		public static ITS_TBL_Interview_Schedule_Entity convertScheduleToScheduleEntity(ITS_TBL_Interview_Schedule schedule) {
			return new ITS_TBL_Interview_Schedule_Entity(schedule.getInterviewId(),schedule.getSubject(),schedule.getInterviewDate(),
					schedule.getInterviewTime(),schedule.getTechRating(),schedule.getEmpHRInterviewDate(),schedule.getEmpHRInterviewTime()
					,schedule.getEmpHRRating(),schedule.getResult(),schedule.getShareResult());

		}
	

}