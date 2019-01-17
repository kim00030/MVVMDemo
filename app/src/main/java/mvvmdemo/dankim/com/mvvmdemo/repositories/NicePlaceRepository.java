package mvvmdemo.dankim.com.mvvmdemo.repositories;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import mvvmdemo.dankim.com.mvvmdemo.models.NicePlace;

/**
 * Created by Dan Kim on 2019-01-17
 */
public class NicePlaceRepository {

    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance() {

        if (instance == null) {
            instance = new NicePlaceRepository();
        }
        return instance;
    }

    // TODO: 2019-01-17 pretend to get data from a web server
    public MutableLiveData<List<NicePlace>> getNicePlaces() {

        setNicePlaces();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setNicePlaces() {

        dataSet.add(new NicePlace("agapanthus", "http://services.hanselandpetal.com/photos/agapanthus.jpg"));
        dataSet.add(new NicePlace("aloe", "http://services.hanselandpetal.com/photos/aloe_vera.jpg"));
        dataSet.add(new NicePlace("bougainvillea", "http://services.hanselandpetal.com/photos/bougainvillea.jpg"));
        dataSet.add(new NicePlace("dusty_miller", "http://services.hanselandpetal.com/photos/dusty_miller.jpg"));
        dataSet.add(new NicePlace("salvia", "http://services.hanselandpetal.com/photos/salvia.jpg"));
        dataSet.add(new NicePlace("exotic_dancer", "http://services.hanselandpetal.com/photos/exotic_dancer.jpg"));
        dataSet.add(new NicePlace("lithops", "http://services.hanselandpetal.com/photos/lithops.jpg"));
        dataSet.add(new NicePlace("cymbidium", "http://services.hanselandpetal.com/photos/cymbidium.jpg"));

    }

}
