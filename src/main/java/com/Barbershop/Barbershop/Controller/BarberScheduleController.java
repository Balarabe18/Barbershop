package com.Barbershop.Barbershop.Controller;

import com.Barbershop.Barbershop.Entity.BarberSchedule;
import com.Barbershop.Barbershop.Service.BarberScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/barber-schedules")
public class BarberScheduleController {

    @Autowired
    private BarberScheduleService barberScheduleService;

    @PostMapping
    public ResponseEntity<BarberSchedule> createSchedule(@RequestBody BarberSchedule schedule) {
        BarberSchedule createdSchedule = barberScheduleService.createSchedule(schedule);
        return ResponseEntity.ok(createdSchedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BarberSchedule>> getScheduleById(@PathVariable Long id) {
        Optional<BarberSchedule> schedule = barberScheduleService.getScheduleById(id);
        return ResponseEntity.ok(schedule);
    }

    @GetMapping
    public ResponseEntity<List<BarberSchedule>> getAllSchedules() {
        List<BarberSchedule> schedules = barberScheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarberSchedule> updateSchedule(@PathVariable Long id, @RequestBody BarberSchedule schedule) {
        schedule.setScheduleId(id);  // Assuming the entity has a setter for the schedule ID
        BarberSchedule updatedSchedule = barberScheduleService.updateSchedule(schedule);
        return ResponseEntity.ok(updatedSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        barberScheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}

