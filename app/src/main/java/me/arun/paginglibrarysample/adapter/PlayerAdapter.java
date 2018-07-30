package me.arun.paginglibrarysample.adapter;


import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import me.arun.paginglibrarysample.R;
import me.arun.paginglibrarysample.model.Player;


public class PlayerAdapter extends PagedListAdapter<Player,PlayerAdapter.PlayerViewHolder>
{
   Context context;

    public PlayerAdapter(Context context)
    {
        super(DIFF_CALLBACK);
        this.context=context;
    }

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_player_row, parent, false);
        return new PlayerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position)
    {
        Player pokemon = getItem(position);

        if (pokemon != null)
        {
            holder.bindTo(pokemon);
        } else {
            holder.clear();
        }
    }



    public static final DiffUtil.ItemCallback<Player> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Player>()
            {
                @Override
                public boolean areItemsTheSame(
                        @NonNull Player oldUser, @NonNull Player newUser)
                {
                    // User properties may have changed if reloaded from the DB, but ID is fixed
                    return oldUser.getPid() == newUser.getPid();
                }
                @Override
                public boolean areContentsTheSame(
                        @NonNull Player oldUser, @NonNull Player newUser)
                {
                    // NOTE: if you use equals, your object must properly override Object#equals()
                    // Incorrectly returning false here will result in too many animations.
                    return oldUser.equals(newUser);
                }
            };


    public class PlayerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivProfile;
        TextView tvName,tvBattingStyle,tvRole,tvBowlingStyle,tvMajorTeams;

        public PlayerViewHolder(View itemView)
        {
            super(itemView);
            ivProfile=(ImageView)itemView.findViewById(R.id.ivProfile);
            tvBattingStyle=(TextView) itemView.findViewById(R.id.tvBattingStyle);
            tvBowlingStyle=(TextView) itemView.findViewById(R.id.tvBowlingStyle);
            tvMajorTeams=(TextView) itemView.findViewById(R.id.tvMajerTeams);
            tvRole=(TextView) itemView.findViewById(R.id.tvRole);
            tvName=(TextView) itemView.findViewById(R.id.tvName);

        }

        void bindTo(Player player)
        {
            itemView.setTag(player.getPid());
            Glide.with(itemView.getContext()).load(player.getImageURL()).into(ivProfile);
            tvName.setText(player.getFullName());
                    tvBattingStyle.setText(player.getBattingStyle());
                            tvRole.setText(player.getPlayingRole());
                            tvBowlingStyle.setText(player.getBowlingStyle());
                                    tvMajorTeams.setText(player.getMajorTeams());
        }

        void clear()
        {
            itemView.invalidate();
           ivProfile.invalidate();
           tvRole.invalidate();
           tvName.invalidate();
           tvMajorTeams.invalidate();
           tvBattingStyle.invalidate();
           tvBowlingStyle.invalidate();
        }
    }
}
