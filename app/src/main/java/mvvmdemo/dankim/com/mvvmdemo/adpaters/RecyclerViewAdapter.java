package mvvmdemo.dankim.com.mvvmdemo.adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import mvvmdemo.dankim.com.mvvmdemo.R;
import mvvmdemo.dankim.com.mvvmdemo.activities.DetailedActivity;
import mvvmdemo.dankim.com.mvvmdemo.models.NicePlace;

/**
 * Created by Dan Kim on 2019-01-16
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {

    public static final String TAG = RecyclerViewAdapter.class.getSimpleName();

    private List<NicePlace> nicePlaceList;
    private Context context;
    private Callback callback;

    public RecyclerViewAdapter(Context context, List<NicePlace> nicePlaceList) {

        this.context = context;
        this.nicePlaceList = nicePlaceList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {

        Glide.with(this.context)
                .load(this.nicePlaceList.get(position).getImageUrl())
                .into(itemViewHolder.circleImageView);

        itemViewHolder.tvImageName.setText(nicePlaceList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return nicePlaceList == null ? 0:nicePlaceList.size();
    }

    public void setCallback(Callback mCallback) {
        this.callback = mCallback;
    }

    public void update(List<NicePlace> mNicePlaceList){
        nicePlaceList = mNicePlaceList;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CircleImageView circleImageView;
        private TextView tvImageName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            circleImageView = itemView.findViewById(R.id.iv_image);
            tvImageName = itemView.findViewById(R.id.tv_image_name);
        }

        @Override
        public void onClick(View v) {

            Log.d(TAG, "You click: " + getAdapterPosition());
            if (getAdapterPosition() != RecyclerView.NO_POSITION) {
                callback.onItemSelected(nicePlaceList.get(getAdapterPosition()).getImageUrl(),
                        nicePlaceList.get(getAdapterPosition()).getTitle());

            }
        }
    }

    public interface Callback {

        void onItemSelected(String imageUrl, String imageName);
    }
}
