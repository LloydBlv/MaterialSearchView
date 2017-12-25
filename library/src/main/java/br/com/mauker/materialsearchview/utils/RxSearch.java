package br.com.mauker.materialsearchview.utils;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import br.com.mauker.materialsearchview.MaterialSearchView;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by mohammadrezanajafi on 11/4/17.
 */

public class RxSearch {

  public static Observable<String> fromSearchView(@NonNull final MaterialSearchView searchView) {
    //final BehaviorSubject<String> subject = BehaviorSubject.create("");
    final BehaviorSubject<String> subject = BehaviorSubject.create();

    searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {

      @Override
      public boolean onQueryTextSubmit(String query) {
        searchView.mSearchViewListener.onTextSubmitted(query);
        subject.onComplete();
        return true;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        Log.e("RxSearch", "onQueryTextChange:" + newText);
        //if (!newText.isEmpty()) {
          subject.onNext(newText);
        //}
        return true;
      }
    });

    return subject;
  }

}