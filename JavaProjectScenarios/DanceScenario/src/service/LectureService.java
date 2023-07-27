package service;

import model.*;

import java.util.Set;

public class LectureService {

    public Lecture createLecture(String name, Branch branch, int capacity) {

        Lecture lecture = new Lecture();
        lecture.setName(name);
        lecture.setCapacity(capacity);
        lecture.setBranch(branch);

        return lecture;
    }

    // Lecture(ders) oluşturulsa bile eğitmen henüz işe alınmamış olabilir
    // veya eğitmeni değiştirmek isteyebilirim
    // o yüzden derse eğitmen atama işlemini createLecture metodunda yapmak yerine
    // ayrı metod tanımladık
    public void addInstructorToLecture(Lecture lecture, Instructor instructor) {

        lecture.setInstructor(instructor);
    }

    public void addScheduleTimeToLecture(Lecture lecture, Set<LectureScheduleTime> lectureScheduleTimeSet) {

        if (lecture.getLectureScheduleTimeSet() != null) {
            lecture.getLectureScheduleTimeSet().addAll(lectureScheduleTimeSet);
        } else {
            lecture.setLectureScheduleTimeSet(lectureScheduleTimeSet);
        }

    }


    public void autoGenerateScheduleTimeForLecture(Lecture lecture, RepeatedTime repeatedTime, String time) {
    }


}
