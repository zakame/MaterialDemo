package net.zakame.materialdemo;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class WordListFragment extends ListFragment
{
    private static final String[] items
        = { "foo", "bar", "baz", "red", "blue", "yellow", "green" };
    private ArrayAdapter<String> adapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        menu.clear();
        inflater.inflate(R.menu.list_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
        case R.id.add:
            addWord();
            return true;
        case R.id.reset:
            initAdapter();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        if (adapter == null) {
            adapter = new ArrayAdapter<String>(getActivity(),
                                               android.R.layout.simple_list_item_1,
                                               new ArrayList<String>());
            setListAdapter(adapter);
            initAdapter();
        }
    }

    private void initAdapter()
    {
        adapter.clear();

        for (int i = 0; i < 3; i++) {
            adapter.add(items[i]);
        }
    }

    private void addWord()
    {
        if (adapter.getCount() < items.length) {
            adapter.add(items[adapter.getCount()]);
        }
    }
}
