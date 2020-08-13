package com.mcdonald.services;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
	public Optional<T> read(int id);
	public List<T> readAll();
	public void create(T t);
	public void update(T t);
	public void delete(int id);
}
