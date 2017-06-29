package com.lumpofcode.collection.binarytree;

import com.lumpofcode.annotation.NotNull;
import com.lumpofcode.collection.compare.ComparableComparator;

import java.util.Comparator;

/**
 * Created by emurphy on 6/28/17.
 */
public class BinarySearchTree<T>
{
	final BinaryTree<T> tree;
	final Comparator<T> comparator;
	
	/**
	 * construct and empty binary search tree.
	 *
	 * @param comparator the comparator used to compare elements in the tree
	 */
	public BinarySearchTree(@NotNull final Comparator<T> comparator)
	{
		this(BinaryTree.Nil, comparator);
	}
	
	/*
	 * private constructor
	 *
	 * @param tree
	 * @param comparator
	 */
	private BinarySearchTree(@NotNull final BinaryTree<T> tree, @NotNull final Comparator<T> comparator)
	{
		if(null == tree) throw new IllegalArgumentException();
		if(null == comparator) throw new IllegalArgumentException();
		
		this.tree = tree;
		this.comparator = comparator;
	}
	
	/**
	 * Find the value in a sorted order based on the given Comparator.
	 * If it is found, update it.  If not found, insert it.
	 *
	 * @param value NotNull
	 * @return a new tree
	 */
	public BinarySearchTree<T> insert(final @NotNull T value)
	{
		return new BinarySearchTree(tree.insert(value, comparator), comparator);
	}
	
	/**
	 * Find and update the value based on the given Comparator.
	 * If the value is not found, the tree is not changed.
	 *
	 * @param value NotNull
	 * @return a new tree
	 */
	public BinarySearchTree<T> update(final @NotNull T value)
	{
		return new BinarySearchTree(tree.update(value, comparator), comparator);
	}
	
	/**
	 * Find and remove the node with the given value,
	 * the promote the left side when rebalancing the tree.
	 *
	 * NOTE: this is a recursive algorithm that reallocates
	 *       nodes in the tree to create a new tree.  This
	 *       happens even if the node that is to be removed
	 *       does not exist (actually, that results in worst-case
	 *       behavior).  If you wish to avoid the extra memory
	 *       allocations is the value does not exist, then
	 *       do a find() for the value first.
	 *
	 * @param value
	 * @return a new tree with the value removed and left side promoted.
	 */
	public BinarySearchTree<T> removePromoteLeft(final @NotNull T value)
	{
		return new BinarySearchTree(tree.removePromoteLeft(value, comparator), comparator);
	}
	
	/**
	 * Find and remove the node with the given value,
	 * the promote the right side when rebalancing the tree.
	 *
	 * NOTE: this is a recursive algorithm that reallocates
	 *       nodes in the tree to create a new tree.  This
	 *       happens even if the node that is to be removed
	 *       does not exist (actually, that results in worst-case
	 *       behavior).  If you wish to avoid the extra memory
	 *       allocations is the value does not exist, then
	 *       do a find() for the value first.
	 *
	 * @param value
	 * @return a new tree with the value removed and right side promoted.
	 */
	public BinarySearchTree<T> removePromoteRight(final @NotNull T value)
	{
		return new BinarySearchTree(tree.removePromoteRight(value, comparator), comparator);
	}
	
}
