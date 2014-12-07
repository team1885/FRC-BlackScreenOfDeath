package org.ilite.util.lang;

public interface IProvider<T>
{
  public void addListener(IUpdate<T> pListener);
  public void removeListener(IUpdate<T> pListener);
  public T getLatest();
}
