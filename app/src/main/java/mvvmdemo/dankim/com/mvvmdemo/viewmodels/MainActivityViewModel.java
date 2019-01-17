package mvvmdemo.dankim.com.mvvmdemo.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import mvvmdemo.dankim.com.mvvmdemo.models.NicePlace;
import mvvmdemo.dankim.com.mvvmdemo.repositories.NicePlaceRepository;

/**
 * Created by Dan Kim on 2019-01-16
 */
public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<NicePlace>> listMutableLiveData;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        listMutableLiveData = NicePlaceRepository.getInstance().getNicePlaces();
    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return listMutableLiveData;
    }
}
