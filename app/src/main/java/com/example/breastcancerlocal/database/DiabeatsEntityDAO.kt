package com.example.breastcancerlocal.database

import androidx.room.*
import com.example.breastcancerlocal.database.DiabeatsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DiabeatsEntityDAO {
    //LiveData
    //Read (list entity)
    @Query("SELECT * FROM diabeats_table")
    fun listDiabeatss(): Flow<List<DiabeatsEntity>>

    //Read (list id)
	@Query("SELECT id FROM diabeats_table")
	fun listDiabeatsids (): Flow<List<String>>
    //Read (list pregnancies)
	@Query("SELECT pregnancies FROM diabeats_table")
	fun listDiabeatspregnanciess (): Flow<List<Int>>
    //Read (list glucose)
	@Query("SELECT glucose FROM diabeats_table")
	fun listDiabeatsglucoses (): Flow<List<Int>>
    //Read (list bloodPressure)
	@Query("SELECT bloodPressure FROM diabeats_table")
	fun listDiabeatsbloodPressures (): Flow<List<Int>>
    //Read (list skinThickness)
	@Query("SELECT skinThickness FROM diabeats_table")
	fun listDiabeatsskinThicknesss (): Flow<List<Int>>
    //Read (list insulin)
	@Query("SELECT insulin FROM diabeats_table")
	fun listDiabeatsinsulins (): Flow<List<Int>>
    //Read (list BMI)
	@Query("SELECT BMI FROM diabeats_table")
	fun listDiabeatsBMIs (): Flow<List<Double>>
    //Read (list diabetesPedigreeFunction)
	@Query("SELECT diabetesPedigreeFunction FROM diabeats_table")
	fun listDiabeatsdiabetesPedigreeFunctions (): Flow<List<Double>>
    //Read (list age)
	@Query("SELECT age FROM diabeats_table")
	fun listDiabeatsages (): Flow<List<Int>>
    //Read (list outcome)
	@Query("SELECT outcome FROM diabeats_table")
	fun listDiabeatsoutcomes (): Flow<List<String>>

	//Suspend
    //Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createDiabeats (diabeats: DiabeatsEntity)

    //Read (list entity with suspend)
    @Query("SELECT * FROM diabeats_table")
    suspend fun listDiabeats(): List<DiabeatsEntity>

    //Update
    @Update
    suspend fun updateDiabeats (diabeats: DiabeatsEntity)

    //Delete all records
    @Query("DELETE FROM diabeats_table")
    suspend fun deleteDiabeatss ()

    //Delete a single record by PK
    @Query("DELETE FROM diabeats_table WHERE id = :id")
    suspend fun deleteDiabeats (id: String)
    
    //Search with live data
	@Query("SELECT * FROM  diabeats_table WHERE id LIKE :searchQuery ")
	fun searchByDiabeatsid(searchQuery: String): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeats_table WHERE pregnancies LIKE :searchQuery ")
	fun searchByDiabeatspregnancies(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeats_table WHERE glucose LIKE :searchQuery ")
	fun searchByDiabeatsglucose(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeats_table WHERE bloodPressure LIKE :searchQuery ")
	fun searchByDiabeatsbloodPressure(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeats_table WHERE skinThickness LIKE :searchQuery ")
	fun searchByDiabeatsskinThickness(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeats_table WHERE insulin LIKE :searchQuery ")
	fun searchByDiabeatsinsulin(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeats_table WHERE BMI LIKE :searchQuery ")
	fun searchByDiabeatsBMI(searchQuery: Double): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeats_table WHERE diabetesPedigreeFunction LIKE :searchQuery ")
	fun searchByDiabeatsdiabetesPedigreeFunction(searchQuery: Double): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeats_table WHERE age LIKE :searchQuery ")
	fun searchByDiabeatsage(searchQuery: Int): Flow<List<DiabeatsEntity>>
	@Query("SELECT * FROM  diabeats_table WHERE outcome LIKE :searchQuery ")
	fun searchByDiabeatsoutcome(searchQuery: String): Flow<List<DiabeatsEntity>>

    //Search with suspend
    @Query("SELECT * FROM  diabeats_table WHERE id LIKE :searchQuery")
	suspend fun searchByDiabeatsid2(searchQuery: String): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeats_table WHERE pregnancies LIKE :searchQuery")
	suspend fun searchByDiabeatspregnancies2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeats_table WHERE glucose LIKE :searchQuery")
	suspend fun searchByDiabeatsglucose2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeats_table WHERE bloodPressure LIKE :searchQuery")
	suspend fun searchByDiabeatsbloodPressure2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeats_table WHERE skinThickness LIKE :searchQuery")
	suspend fun searchByDiabeatsskinThickness2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeats_table WHERE insulin LIKE :searchQuery")
	suspend fun searchByDiabeatsinsulin2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeats_table WHERE BMI LIKE :searchQuery")
	suspend fun searchByDiabeatsBMI2(searchQuery: Double): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeats_table WHERE diabetesPedigreeFunction LIKE :searchQuery")
	suspend fun searchByDiabeatsdiabetesPedigreeFunction2(searchQuery: Double): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeats_table WHERE age LIKE :searchQuery")
	suspend fun searchByDiabeatsage2(searchQuery: Int): List<DiabeatsEntity>
    @Query("SELECT * FROM  diabeats_table WHERE outcome LIKE :searchQuery")
	suspend fun searchByDiabeatsoutcome2(searchQuery: String): List<DiabeatsEntity>

}
