package com.halilkaya.themematerial

class NavigationDrawerItem {

    var baslik:String = ""
    var resimId:Int = 0

    companion object{

        fun getData():ArrayList<NavigationDrawerItem>{

            var dataList:ArrayList<NavigationDrawerItem> = ArrayList()

            var resimler = getImages()
            var basliklar = getBaslig()

            for(i in 0..(resimler.size-1)){

                var nb = NavigationDrawerItem()
                nb.baslik = basliklar.get(i)
                nb.resimId = resimler.get(i)

                dataList.add(nb)

            }

            return dataList

        }


        fun getBaslig():Array<String>{
            var array:Array<String> = arrayOf("Addicon"
                ,"deleteicon"
                ,"editicon"
                ,"mailicon"
                ,"plusicon")


            return array
        }

        fun getImages():Array<Int>{
            var array:Array<Int> = arrayOf(R.drawable.addicon
                ,R.drawable.deleteicon
                ,R.drawable.editicon
                ,R.drawable.addicon
                ,R.drawable.plusicon)

            return array
        }


    }

}