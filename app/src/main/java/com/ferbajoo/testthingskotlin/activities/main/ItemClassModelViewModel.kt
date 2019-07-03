package com.ferbajoo.testthingskotlin.activities.main

import com.ferbajoo.testthingskotlin.core.models.ClassModel

class ItemClassModelViewModel(activitie: ClassModel) {

    val name = activitie.name
    val description = activitie.description

    val drawable = activitie.drawable

}