package com.urise.webapp.storage;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage  {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }
    public void update(Resume r) {
        for (int i = 0; i < size + 1; i++){
            if (storage[i] == null){
                storage[i] = r;
                size ++;
                break;
            }
            if (storage[i].getUuid() == r.getUuid()){
                System.out.println("Error resume r под номером: " + r.getUuid() +
                        " уже существует");
                break;
            }
        }
        System.out.println("ERROR");
    }

    public void save(Resume r) {
        for (int i = 0; i < size + 1; i++){
            if (storage[i] == null){
                storage[i] = r;
                size ++;
                break;
            }
            if (storage[i].getUuid() == r.getUuid()){
                System.out.println("Error resume r под номером: " + r.getUuid() +
                        " уже существует");
                break;
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        //TODO check if resume  present
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()){
                storage[i] = storage[size-1];
                storage[size-1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

}
