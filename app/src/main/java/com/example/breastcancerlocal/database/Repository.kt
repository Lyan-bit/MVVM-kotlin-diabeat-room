package com.example.breastcancerlocal.database

import com.example.breastcancerlocal.DiabeatsApplication
import kotlinx.coroutines.flow.Flow

class Repository : DiabeatsRepository {

    private val diabeatsDAO: DiabeatsEntityDAO by lazy { DiabeatsApplication.database.diabeatsDao() }

    val allDiabeatss: Flow<List<DiabeatsEntity>> = diabeatsDAO.listDiabeatss()

    val allDiabeatsids: Flow<List<String>> = diabeatsDAO.listDiabeatsids()
    val allDiabeatspregnanciess: Flow<List<Int>> = diabeatsDAO.listDiabeatspregnanciess()
    val allDiabeatsglucoses: Flow<List<Int>> = diabeatsDAO.listDiabeatsglucoses()
    val allDiabeatsbloodPressures: Flow<List<Int>> = diabeatsDAO.listDiabeatsbloodPressures()
    val allDiabeatsskinThicknesss: Flow<List<Int>> = diabeatsDAO.listDiabeatsskinThicknesss()
    val allDiabeatsinsulins: Flow<List<Int>> = diabeatsDAO.listDiabeatsinsulins()
    val allDiabeatsBMIs: Flow<List<Double>> = diabeatsDAO.listDiabeatsBMIs()
    val allDiabeatsdiabetesPedigreeFunctions: Flow<List<Double>> = diabeatsDAO.listDiabeatsdiabetesPedigreeFunctions()
    val allDiabeatsages: Flow<List<Int>> = diabeatsDAO.listDiabeatsages()
    val allDiabeatsoutcomes: Flow<List<String>> = diabeatsDAO.listDiabeatsoutcomes()

    //Create
    override suspend fun createDiabeats(diabeats: DiabeatsEntity) {
        diabeatsDAO.createDiabeats(diabeats)
    }

    //Read
    override suspend fun listDiabeats(): List<DiabeatsEntity> {
        return diabeatsDAO.listDiabeats()
    }

    //Update
    override suspend fun updateDiabeats(diabeats: DiabeatsEntity) {
        diabeatsDAO.updateDiabeats(diabeats)
    }

    //Delete all Diabeatss
    override suspend fun deleteDiabeatss() {
       diabeatsDAO.deleteDiabeatss()
    }

    //Delete a Diabeats
	override suspend fun deleteDiabeats(id: String) {
	   diabeatsDAO.deleteDiabeats(id)
    }
    
     //Search with live data
     override fun searchByDiabeatsid (searchQuery: String): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatsid(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatspregnancies (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatspregnancies(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsglucose (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatsglucose(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsbloodPressure (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatsbloodPressure(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsskinThickness (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatsskinThickness(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsinsulin (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatsinsulin(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsBMI (searchQuery: Double): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatsBMI(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsdiabetesPedigreeFunction (searchQuery: Double): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatsdiabetesPedigreeFunction(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsage (searchQuery: Int): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatsage(searchQuery)
     }
     
     //Search with live data
     override fun searchByDiabeatsoutcome (searchQuery: String): Flow<List<DiabeatsEntity>>  {
         return diabeatsDAO.searchByDiabeatsoutcome(searchQuery)
     }
     

    //Search with suspend
     override suspend fun searchByDiabeatsid2 (id: String): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatsid2(id)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatspregnancies2 (pregnancies: Int): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatspregnancies2(pregnancies)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsglucose2 (glucose: Int): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatsglucose2(glucose)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsbloodPressure2 (bloodPressure: Int): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatsbloodPressure2(bloodPressure)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsskinThickness2 (skinThickness: Int): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatsskinThickness2(skinThickness)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsinsulin2 (insulin: Int): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatsinsulin2(insulin)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsBMI2 (bmi: Double): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatsBMI2(bmi)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsdiabetesPedigreeFunction2 (diabetesPedigreeFunction: Double): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatsdiabetesPedigreeFunction2(diabetesPedigreeFunction)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsage2 (age: Int): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatsage2(age)
     }
	     
    //Search with suspend
     override suspend fun searchByDiabeatsoutcome2 (outcome: String): List<DiabeatsEntity> {
          return diabeatsDAO.searchByDiabeatsoutcome2(outcome)
     }
	     


}
