package com.example.homework3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class BookAdapter extends BaseAdapter
{
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, Object>> access = new ArrayList<>();


    public BookAdapter(Context contxt, ArrayList<HashMap<String, Object>> acces)
    {
        context=contxt;
        access=acces;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        if(access.size()<=0)
        {
            return 0;
        }else
        {
            return access.size();
        }
    }

    @Override
    public Object getItem(int i)
    {
        return i;
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    public  static class ViewHolder
    {
        TextView name;
        ImageView image;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View vi = view;
        ViewHolder holder;
        if (view == null) {
            vi = inflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder();
            holder.name = (TextView) vi.findViewById(R.id.baslik);
            holder.image = (ImageView) vi.findViewById(R.id.resim);
            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();
        if (access.size() <= 0) {
            //holder.text.setText("No Data");
        } else {
            /************  Set Model values in Holder elements ***********/
            holder.name.setText(access.get(i).get("Name").toString());

            Picasso.get().load(access.get(i).get("image").toString()).into(holder.image);

        }
        return vi;
    }
}
