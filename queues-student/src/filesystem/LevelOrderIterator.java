package filesystem;

import structures.Queue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;


/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 */
public class LevelOrderIterator extends FileIterator<File> {
	
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */

	private Queue<File> queue;
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		
        if(!rootNode.exists() || rootNode==null)
        	{
        		throw new FileNotFoundException();
        	}
        queue = new Queue<File>();
        queue.enqueue(rootNode);
	}
        
	@Override
	public boolean hasNext(){	
		return(queue.size()!=0);
	}

	@Override
	public File next() throws NoSuchElementException {
      if(!hasNext())
        {
        	throw new NoSuchElementException();
        }
      else
      {
    	  File file = queue.dequeue();
    	  if(file.isDirectory())
    	  {
    		  File [] files = file.listFiles();
    		  Arrays.sort(files);
    		  for(File f: files)
    		        {
    		           queue.enqueue(f);    
    		        }
    		
    	  }
    	  return file;
      }

    
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
