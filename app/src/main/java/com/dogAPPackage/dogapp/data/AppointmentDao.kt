package com.dogAPPackage.dogapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dogAPPackage.dogapp.model.Appointment


@Dao
interface AppointmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAppointment(appointment: Appointment)

    @Query("SELECT * FROM Appointment")
    suspend fun getListAppointment(): MutableList<Appointment>

    @Delete
    suspend fun deleteAppointment(appointment: Appointment)

    @Update
    suspend fun updateAppointment(appointment: Appointment)

    //Consultar por id para  editar
    @Query("SELECT * FROM Appointment WHERE id = :id")
    suspend fun getAppointmentById(id: Int): Appointment?

}