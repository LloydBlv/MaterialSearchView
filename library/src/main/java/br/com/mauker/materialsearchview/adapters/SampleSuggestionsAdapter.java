package br.com.mauker.materialsearchview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.mauker.materialsearchview.R;
import java.util.ArrayList;

/**
 * Created by mohammadrezanajafi on 11/4/17.
 */

public class SampleSuggestionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  public final ArrayList<String> mItems = new ArrayList<>();

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ((ViewHolder) holder).bind(mItems.get(position));

  }

  @Override public int getItemCount() {
    return mItems.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder{
    final TextView mTitleTV;
    ViewHolder(View itemView) {
      super(itemView);
      mTitleTV = itemView.findViewById(R.id.tv_str);
    }

    void bind(final String title){
      mTitleTV.setText(title);
    }
  }
}
