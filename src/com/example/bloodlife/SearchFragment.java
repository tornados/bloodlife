package com.example.bloodlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SearchFragment extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_search, container, false);
		
	}
	
	public void onStart() {
		super.onStart();
		Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner_blood_group);
		ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(getActivity(), R.array.blood_group, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
}