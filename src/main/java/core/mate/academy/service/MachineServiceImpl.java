package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;

import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T>{
    @Override
    public List<T> getAll(Class<? extends T> type) {
        if(Bulldozer.class == type){
            BulldozerProducer bulldozerProducer = new BulldozerProducer();
            return (List<T>) bulldozerProducer.get();
        } else if (type == Excavator.class){
            ExcavatorProducer excavatorProducer = new ExcavatorProducer();
            return (List<T>) excavatorProducer.get();
        } else {
            TruckProducer truckProducer = new TruckProducer();
            return (List<T>) truckProducer.get();
        }
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        machines.add(value);
    }

    @Override
    public void startWorking(List<? extends T> machines) {
    }
}
