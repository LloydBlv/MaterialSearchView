package br.com.mauker.materialsearchview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * Created by mohammadrezanajafi on 11/3/17.
 */

public abstract class SuggestionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  abstract void bindView(final RecyclerView.ViewHolder holder, final int position);
  abstract RecyclerView.ViewHolder createView(ViewGroup parent, int viewType);
  abstract int getDataSetSize();


  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return createView(parent, viewType);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    bindView(holder, position);
  }

  @Override public int getItemCount() {
    return getDataSetSize();
  }
}
