package com.finance.databaselibrary.controller;

import com.finance.databaselibrary.model.Schedule;
import com.finance.databaselibrary.repository.ScheduleRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleRepository repository;

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "{ \"status\" : \"healthy\" }";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Schedule> getAllSchedules() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Schedule createSchedule(@Valid @RequestBody Schedule schedule) {
        schedule.set_id(ObjectId.get());
        this.repository.save(schedule);
        return schedule;
    }

    @RequestMapping(value = "/{symbol}", method = RequestMethod.DELETE)
    public void deleteSchedules(@PathVariable("symbol") String symbol) {
        List<Schedule> schedules = this.repository.findBySymbol(symbol);

        for (Schedule schedule : schedules) {
            this.repository.delete(schedule);
        }
    }
}
