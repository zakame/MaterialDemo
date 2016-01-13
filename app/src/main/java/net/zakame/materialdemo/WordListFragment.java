package net.zakame.materialdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class WordListFragment extends RecyclerViewFragment
{
    private static final String[] items
        = { "foo", "bar", "baz", "red", "blue", "yellow", "green" };
    private WordListAdapter adapter = null;

    public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordHolder>
    {
        private ArrayList<String> wordList = null;

        public class WordHolder extends RecyclerView.ViewHolder
        {
            TextView word = null;

            WordHolder(View row)
            {
                super(row);

                word = (TextView) row.findViewById(R.id.word);
            }

            void bindModel(String item)
            {
                word.setText(item);
            }
        }

        WordListAdapter()
        {
            wordList = new ArrayList<String>();
        }

        public void init()
        {
            wordList.clear();
            for (int i = 0; i < 3; i++) {
                wordList.add(items[i]);
            }
            notifyDataSetChanged();
        }

        public void addWord()
        {
            if (getItemCount() < items.length) {
                wordList.add(items[getItemCount()]);
                notifyItemInserted(wordList.size() - 1);
            }
        }

        @Override
        public WordListAdapter.WordHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View row = getActivity().getLayoutInflater().inflate(R.layout.word_holder, parent, false);
            return new WordHolder(row);
        }

        @Override
        public void onBindViewHolder(WordListAdapter.WordHolder holder, int position)
        {
            holder.bindModel(wordList.get(position));
        }

        @Override
        public int getItemCount()
        {
            return wordList.size();
        }
    }

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
            adapter.addWord();
            return true;
        case R.id.reset:
            adapter.init();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        setLayoutManager(new LinearLayoutManager(getActivity()));
        if (adapter == null) {
            adapter = new WordListAdapter();
            setAdapter(adapter);
            adapter.init();
        }
    }
}
