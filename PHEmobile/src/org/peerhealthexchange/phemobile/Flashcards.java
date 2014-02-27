package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Flashcards extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.flashcards, container, false);

		ActionBar locationPage = getActivity().getActionBar();
		locationPage.setTitle("Flashcards");

		final Button alcAndDrugsButton = (Button) getView().findViewById(
				R.id.alcAndDrugsButton);
		final Button eatingDisordersButton = (Button) getView().findViewById(
				R.id.eatingDisordersButton);
		final Button glbtButton = (Button) getView().findViewById(
				R.id.glbtButton);
		final Button nutrAndFitButton = (Button) getView().findViewById(
				R.id.nutrAndFitButton);
		final Button sexButton = (Button) getView()
				.findViewById(R.id.sexButton);

		alcAndDrugsButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), question_cards.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("activity", alcAndDrugsButton.getText());
				startActivity(intent);
			}
		});

		eatingDisordersButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), question_cards.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("activity", eatingDisordersButton.getText());
				startActivity(intent);
			}
		});

		glbtButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), question_cards.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("activity", glbtButton.getText());
				startActivity(intent);
			}
		});

		nutrAndFitButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), question_cards.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("activity", nutrAndFitButton.getText());
				startActivity(intent);
			}
		});

		sexButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), question_cards.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("activity", sexButton.getText());
				startActivity(intent);
			}
		});
		return rootView;
	}

}
