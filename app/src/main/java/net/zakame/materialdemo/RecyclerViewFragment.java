package net.zakame.materialdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RecyclerView rv = new RecyclerView(getActivity());
        rv.setHasFixedSize(true);

        return rv;
    }

    public void setAdapter(RecyclerView.Adapter adapter)
    {
        getRecyclerView().setAdapter(adapter);
    }

    public RecyclerView.Adapter getAdapter()
    {
        return getRecyclerView().getAdapter();
    }

    public void setLayoutManager(RecyclerView.LayoutManager mgr)
    {
        getRecyclerView().setLayoutManager(mgr);
    }

    public RecyclerView getRecyclerView()
    {
        return (RecyclerView) getView();
    }
}
