package com.Barbershop.Barbershop.Service;


import com.Barbershop.Barbershop.Entity.BarberSchedule;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

    public interface BarberScheduleService {
        BarberSchedule createSchedule(BarberSchedule schedule);
        Optional<BarberSchedule> getScheduleById(Long id);
        List<BarberSchedule> getAllSchedules();
        List<BarberSchedule> getSchedulesByBarber(Long barberId);
        List<BarberSchedule> getSchedulesByDay(DayOfWeek day);
        BarberSchedule updateSchedule(BarberSchedule schedule);
        void deleteSchedule(Long id);
        boolean isBarberAvailable(Long barberId, DayOfWeek day, int hour);
        List<BarberSchedule> getBarberAvailability(Long barberId);
}
