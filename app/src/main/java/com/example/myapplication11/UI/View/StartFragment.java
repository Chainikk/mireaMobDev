package com.example.myapplication11.UI.View;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication11.DATA.DataSources.Room.DAO.DayDAO;
import com.example.myapplication11.DATA.DataSources.Repository;
import com.example.myapplication11.DATA.DataSources.Room.AppDatabase;
import com.example.myapplication11.DATA.DataSources.Room.Entities.DayEntity;
import com.example.myapplication11.DATA.Model.FragmentNavigateData;
import com.example.myapplication11.R;

import java.util.List;

public class StartFragment extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 80;
    public FragmentNavigateData data = new FragmentNavigateData();
    public StartFragment() {
        super(R.layout.fragment_start);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        Repository repository = new Repository(this.getContext(), "file.txt", "SDFile");

        AppDatabase db = Room.databaseBuilder(this.getActivity().getApplication(),
                AppDatabase.class, "database-name").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        DayDAO dayDao = db.listDAO();
        DayEntity dayEntity2 = new DayEntity();
        dayEntity2.dayName = "Monday";
        dayEntity2.description = "Some description";
        /*List<DayEntity> days = dayDao.getAll();*/
        view.findViewById(R.id.common_files_ds).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (!repository.writeCommonFileDS("Данные, записанные в общее хранилище")) {
                    requestPermission();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    repository.writeCommonFileDS("Данные, записанные в общее хранилище");
                }
                String result = repository.readCommonFilesDS();
                itemNameCommon.setText(result);*/
                dayDao.insert(dayEntity2);
                DayEntity entity2 = dayDao.getDayByName("Monday");
                TextView name = view.findViewById(R.id.name);
                name.setText(entity2.dayName);
                TextView description = view.findViewById(R.id.description);
                description.setText(entity2.description);
                EditText editText = view.findViewById(R.id.editField1);
                //editText.setText(entity2.dayName);
            }
        });
        view.findViewById(R.id.toListFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String result = data.getDataFromStartToList();
                bundle.putString("listKey", result);
                Navigation.findNavController(v).navigate(R.id.from_start_to_list, bundle);
            }
        });

        view.findViewById(R.id.toRecyclerFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String result = data.getDataFromStartToRecycler();
                bundle.putString("recyclerKey", result);
                Navigation.findNavController(v).navigate(R.id.from_start_to_recycler, bundle);
            }
        });
        return view;
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(getContext(), "Требуется разрешение на запись на карту памяти!", Toast.LENGTH_LONG).show();
        }
        else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE && (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
            Log.e("value", "Разрешение есть.");
        }
    }
}
