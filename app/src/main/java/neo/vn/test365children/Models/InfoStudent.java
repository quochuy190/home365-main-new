package neo.vn.test365children.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InfoStudent extends RealmObject {

    private String id;
    @PrimaryKey
    private String idChild;
    private String city;
    private String district;
    private String school;
    private String className;
    private String kidName;
    private String cityID;
    private String districtID;
    private String schoolID;

    public InfoStudent(String id, String idChild, String city, String district, String school, String className, String kidName, String cityID, String districtID, String schoolID) {
        this.id = id;
        this.idChild = idChild;
        this.city = city;
        this.district = district;
        this.school = school;
        this.className = className;
        this.kidName = kidName;
        this.cityID = cityID;
        this.districtID = districtID;
        this.schoolID = schoolID;
    }

    public String getIdChild() {
        return idChild;
    }

    public void setIdChild(String idChild) {
        this.idChild = idChild;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public InfoStudent() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getKidName() {
        return kidName;
    }

    public void setKidName(String kidName) {
        this.kidName = kidName;
    }
}
