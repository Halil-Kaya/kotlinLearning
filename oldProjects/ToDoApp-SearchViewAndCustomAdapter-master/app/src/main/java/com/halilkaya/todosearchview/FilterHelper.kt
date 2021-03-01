package com.halilkaya.todosearchview

import android.widget.Filter

class FilterHelper(var allTodo:ArrayList<Todo>,var myAdapter:TodoAdapter): Filter() {



    override fun performFiltering(constraint: CharSequence?): FilterResults {

        var filterResults = FilterResults()

        if (constraint != null && constraint.length>0){

            var wantedTodos = ArrayList<Todo>()

            for (todo in allTodo){

                if(todo.baslik.toLowerCase().contains(constraint.toString().toLowerCase())){
                    wantedTodos.add(todo)
                }

            }

            filterResults.values = wantedTodos
            filterResults.count = wantedTodos.size

        }else{
            filterResults.values = allTodo
            filterResults.count = allTodo.size
        }

        return filterResults
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

        myAdapter.setFilter(results?.values as ArrayList<Todo>)

    }

}