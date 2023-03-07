package com.example.breastcancerlocal.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.breastcancerlocal.model.Diabeats
import com.example.breastcancerlocal.database.DiabeatsEntity
import com.example.breastcancerlocal.database.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DiabeatsCRUDViewModel constructor(context: Context): ViewModel() {


    companion object {
        private val repository by lazy { Repository() }
        private var instance: DiabeatsCRUDViewModel? = null
        fun getInstance(context: Context): DiabeatsCRUDViewModel {
            return instance ?: DiabeatsCRUDViewModel(context)
        }
    }

    val allDiabeatss: LiveData<List<DiabeatsEntity>> = repository.allDiabeatss.asLiveData()

    val allDiabeatsIds: LiveData<List<String>> = repository.allDiabeatsids.asLiveData()
    val allDiabeatsPregnanciess: LiveData<List<Int>> = repository.allDiabeatspregnanciess.asLiveData()
    val allDiabeatsGlucoses: LiveData<List<Int>> = repository.allDiabeatsglucoses.asLiveData()
    val allDiabeatsBloodPressures: LiveData<List<Int>> = repository.allDiabeatsbloodPressures.asLiveData()
    val allDiabeatsSkinThicknesss: LiveData<List<Int>> = repository.allDiabeatsskinThicknesss.asLiveData()
    val allDiabeatsInsulins: LiveData<List<Int>> = repository.allDiabeatsinsulins.asLiveData()
    val allDiabeatsBMIs: LiveData<List<Double>> = repository.allDiabeatsBMIs.asLiveData()
    val allDiabeatsDiabetesPedigreeFunctions: LiveData<List<Double>> = repository.allDiabeatsdiabetesPedigreeFunctions.asLiveData()
    val allDiabeatsAges: LiveData<List<Int>> = repository.allDiabeatsages.asLiveData()
    val allDiabeatsOutcomes: LiveData<List<String>> = repository.allDiabeatsoutcomes.asLiveData()

    private var currentDiabeats: DiabeatsEntity? = null
    private var currentDiabeatss: List<DiabeatsEntity> = ArrayList()

    fun searchByDiabeatsid(searchQuery: String): LiveData<List<DiabeatsEntity>> {
        return repository.searchByDiabeatsid(searchQuery).asLiveData()
    }

    fun searchByDiabeatspregnancies(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatspregnancies(searchQuery).asLiveData()
    }

    fun searchByDiabeatsglucose(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsglucose(searchQuery).asLiveData()
    }

    fun searchByDiabeatsbloodPressure(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsbloodPressure(searchQuery).asLiveData()
    }

    fun searchByDiabeatsskinThickness(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsskinThickness(searchQuery).asLiveData()
    }

    fun searchByDiabeatsinsulin(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsinsulin(searchQuery).asLiveData()
    }

    fun searchByDiabeatsBMI(searchQuery: Double): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsBMI(searchQuery).asLiveData()
    }

    fun searchByDiabeatsdiabetesPedigreeFunction(searchQuery: Double): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsdiabetesPedigreeFunction(searchQuery).asLiveData()
    }

    fun searchByDiabeatsage(searchQuery: Int): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsage(searchQuery).asLiveData()
    }

    fun searchByDiabeatsoutcome(searchQuery: String): LiveData<List<DiabeatsEntity>>  {
        return repository.searchByDiabeatsoutcome(searchQuery).asLiveData()
    }


    fun getDiabeatsByPK(_val: String): Flow<Diabeats> {
        val res: Flow<List<DiabeatsEntity>> = repository.searchByDiabeatsid(_val)
        return res.map { diabeats ->
            val itemx = Diabeats.createByPKDiabeats(_val)
            if (diabeats.isNotEmpty()) {
                itemx.id = diabeats[0].id
            }
            if (diabeats.isNotEmpty()) {
                itemx.pregnancies = diabeats[0].pregnancies
            }
            if (diabeats.isNotEmpty()) {
                itemx.glucose = diabeats[0].glucose
            }
            if (diabeats.isNotEmpty()) {
                itemx.bloodPressure = diabeats[0].bloodPressure
            }
            if (diabeats.isNotEmpty()) {
                itemx.skinThickness = diabeats[0].skinThickness
            }
            if (diabeats.isNotEmpty()) {
                itemx.insulin = diabeats[0].insulin
            }
            if (diabeats.isNotEmpty()) {
                itemx.bmi = diabeats[0].bmi
            }
            if (diabeats.isNotEmpty()) {
                itemx.diabetesPedigreeFunction = diabeats[0].diabetesPedigreeFunction
            }
            if (diabeats.isNotEmpty()) {
                itemx.age = diabeats[0].age
            }
            if (diabeats.isNotEmpty()) {
                itemx.outcome = diabeats[0].outcome
            }
            itemx
        }
    }

    suspend fun createDiabeats(_x: DiabeatsEntity) {
        repository.createDiabeats(_x)
        currentDiabeats = _x
    }

    fun setSelectedDiabeats(x: DiabeatsEntity) {
        currentDiabeats = x
    }

    suspend fun editDiabeats(x: DiabeatsEntity) {
        repository.updateDiabeats(x)
        currentDiabeats = x
    }

    suspend fun listDiabeats(): List<DiabeatsEntity> {
        currentDiabeatss = repository.listDiabeats()
        return currentDiabeatss
    }

    suspend fun listAllDiabeats(): ArrayList<Diabeats> {
        currentDiabeatss = repository.listDiabeats()
        var res = ArrayList<Diabeats>()
        for (x in currentDiabeatss.indices) {
            val vo: DiabeatsEntity = currentDiabeatss[x]
            val itemx = Diabeats.createByPKDiabeats(vo.id)
            itemx.id = vo.id
            itemx.pregnancies = vo.pregnancies
            itemx.glucose = vo.glucose
            itemx.bloodPressure = vo.bloodPressure
            itemx.skinThickness = vo.skinThickness
            itemx.insulin = vo.insulin
            itemx.bmi = vo.bmi
            itemx.diabetesPedigreeFunction = vo.diabetesPedigreeFunction
            itemx.age = vo.age
            itemx.outcome = vo.outcome
            res.add(itemx)
        }
        return res
    }

    suspend fun stringListDiabeats(): List<String> {
        currentDiabeatss = repository.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (x in currentDiabeatss.indices) {
            res.add(currentDiabeatss[x].toString())
        }
        return res
    }

    suspend fun getDiabeatsByPK2(_val: String): Diabeats? {
        val res: List<DiabeatsEntity> = repository.searchByDiabeatsid2(_val)
        return if (res.isEmpty()) {
            null
        } else {
            val vo: DiabeatsEntity = res[0]
            val itemx = Diabeats.createByPKDiabeats(_val)
            itemx.id = vo.id
            itemx.pregnancies = vo.pregnancies
            itemx.glucose = vo.glucose
            itemx.bloodPressure = vo.bloodPressure
            itemx.skinThickness = vo.skinThickness
            itemx.insulin = vo.insulin
            itemx.bmi = vo.bmi
            itemx.diabetesPedigreeFunction = vo.diabetesPedigreeFunction
            itemx.age = vo.age
            itemx.outcome = vo.outcome
            itemx
        }
    }

    suspend fun retrieveDiabeats(_val: String): Diabeats? {
        return getDiabeatsByPK2(_val)
    }

    suspend fun allDiabeatsIds(): ArrayList<String> {
        currentDiabeatss = repository.listDiabeats()
        val res: ArrayList<String> = ArrayList()
        for (diabeats in currentDiabeatss.indices) {
            res.add(currentDiabeatss[diabeats].id)
        }
        return res
    }

    fun setSelectedDiabeats(i: Int) {
        if (i < currentDiabeatss.size) {
            currentDiabeats = currentDiabeatss[i]
        }
    }

    fun getSelectedDiabeats(): DiabeatsEntity? {
        return currentDiabeats
    }

    suspend fun persistDiabeats(_x: Diabeats) {
        val vo = DiabeatsEntity(_x.id, _x.pregnancies, _x.glucose, _x.bloodPressure, _x.skinThickness, _x.insulin, _x.bmi, _x.diabetesPedigreeFunction, _x.age, _x.outcome)
        repository.updateDiabeats(vo)
        currentDiabeats = vo
    }

    suspend fun searchByDiabeatsid2(idx: String): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatsid2(idx)
        return currentDiabeatss
    }
    suspend fun searchByDiabeatspregnancies2(pregnanciesx: Int): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatspregnancies2(pregnanciesx)
        return currentDiabeatss
    }
    suspend fun searchByDiabeatsglucose2(glucosex: Int): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatsglucose2(glucosex)
        return currentDiabeatss
    }
    suspend fun searchByDiabeatsbloodPressure2(bloodPressurex: Int): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatsbloodPressure2(bloodPressurex)
        return currentDiabeatss
    }
    suspend fun searchByDiabeatsskinThickness2(skinThicknessx: Int): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatsskinThickness2(skinThicknessx)
        return currentDiabeatss
    }
    suspend fun searchByDiabeatsinsulin2(insulinx: Int): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatsinsulin2(insulinx)
        return currentDiabeatss
    }
    suspend fun searchByDiabeatsBMI2(BMIx: Double): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatsBMI2(BMIx)
        return currentDiabeatss
    }
    suspend fun searchByDiabeatsdiabetesPedigreeFunction2(diabetesPedigreeFunctionx: Double): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatsdiabetesPedigreeFunction2(diabetesPedigreeFunctionx)
        return currentDiabeatss
    }
    suspend fun searchByDiabeatsage2(agex: Int): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatsage2(agex)
        return currentDiabeatss
    }
    suspend fun searchByDiabeatsoutcome2(outcomex: String): List<DiabeatsEntity> {
        currentDiabeatss = repository.searchByDiabeatsoutcome2(outcomex)
        return currentDiabeatss
    }

}