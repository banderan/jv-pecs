package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    @Override
    public List<T> getAll(Class<? extends T> type) {
        if (Bulldozer.class == type) {
            BulldozerProducer bulldozerProducer = new BulldozerProducer();
            List<T> machines = (List<T>) bulldozerProducer.get();
            return new ArrayList<>(machines);
        } else if (type == Excavator.class) {
            ExcavatorProducer excavatorProducer = new ExcavatorProducer();
            List<T> machines = (List<T>) excavatorProducer.get();
            return new ArrayList<>(machines);
        } else if (type == Truck.class) {
            TruckProducer truckProducer = new TruckProducer();
            List<T> machines = (List<T>) truckProducer.get();
            return new ArrayList<>(machines);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i,value);
        }

    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (T element : machines) {
            element.doWork();
        }
    }
}
