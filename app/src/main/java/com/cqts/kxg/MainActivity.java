package com.cqts.kxg;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.BaseActivity;
import com.base.views.MyGridDecoration;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recy);
		LinearLayoutManager manager = new LinearLayoutManager(this);
		manager.setOrientation(OrientationHelper.VERTICAL);


		GridLayoutManager manager1 = new GridLayoutManager(this,3);
		recyclerView.setLayoutManager(manager1);


//		recyclerView.addItemDecoration(new MyItemDecoration(20,Color.RED));
		recyclerView.addItemDecoration(new MyGridDecoration(50,50,Color.RED,false));

		recyclerView.setAdapter(new RecyclerView.Adapter() {
			@Override
			public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
				View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_homerv,null);
				Holser holser = new Holser(view);
				return holser;
			}

			@Override
			public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
			}
			@Override
			public int getItemCount() {
				return 9;
			}
		});
	}

	class Holser extends RecyclerView.ViewHolder{
		public Holser(View itemView) {
			super(itemView);
		}
	}

}
