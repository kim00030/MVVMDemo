package mvvmdemo.dankim.com.mvvmdemo.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

import mvvmdemo.dankim.com.mvvmdemo.models.NicePlace;
import mvvmdemo.dankim.com.mvvmdemo.repositories.NicePlaceRepository;

/**
 * Created by Dan Kim on 2019-01-16
 */
public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<NicePlace>> listMutableLiveData;
    private MutableLiveData<Boolean> isLoadingLiveData = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        listMutableLiveData = NicePlaceRepository.getInstance().getNicePlaces();
    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return listMutableLiveData;
    }

    /**
     * Add new NicePlace object
     * @param nicePlace
     */
    public void addNewNicePlace(final NicePlace nicePlace){

        isLoadingLiveData.setValue(true);

        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                //pretend loading
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentList = listMutableLiveData.getValue();
                // add new entry
                currentList.add(nicePlace);
                listMutableLiveData.postValue(currentList);

                isLoadingLiveData.postValue(false);
            }
        }.execute();
    }

    public LiveData<Boolean> getIsLoading(){
            return isLoadingLiveData;
    }
}
