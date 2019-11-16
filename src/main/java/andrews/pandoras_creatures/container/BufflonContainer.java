package andrews.pandoras_creatures.container;

import andrews.pandoras_creatures.container.slot.BufflonBackAttachmentSlot;
import andrews.pandoras_creatures.container.slot.BufflonSaddleSlot;
import andrews.pandoras_creatures.container.slot.BufflonStorageSlot;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.registry.PCContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class BufflonContainer extends Container
{	
    // Inventory of Bufflon Entity
	private final Inventory bufflonStorge;
    //Instance of Bufflon Entity
    private final BufflonEntity bufflonEntity;
	
	public BufflonContainer(final int windowId, final PlayerInventory playerInventory, PacketBuffer data)
	{
//		super(ModContainerTypes.BUFFLON, windowId);
		this(windowId, playerInventory, data.readInt());
	}
	
	public BufflonContainer(int windowId, PlayerInventory playerInventory, int entityId)
	{
		super(PCContainers.BUFFLON, windowId);
		
        this.bufflonEntity = (BufflonEntity) playerInventory.player.world.getEntityByID(entityId);
        this.bufflonStorge = bufflonEntity.bufflonStorage;

        bufflonStorge.openInventory(playerInventory.player);

        //The Bufflon Saddle Slot
        this.addSlot(new BufflonSaddleSlot(bufflonStorge, 0, -17, 72));
        //The Bufflon Back Attachment Slot
        this.addSlot(new BufflonBackAttachmentSlot(bufflonStorge, 1, 11, 72));
        
        //The Bufflon Inventory
	    for(int y = 0; y < 6; ++y)
	    {
	    	for(int x = 0; x < 9; ++x)
	    	{
	    		this.addSlot(new BufflonStorageSlot(bufflonEntity, bufflonStorge, x + y * 9 + 2, 45 + x * 18, 8 + y * 18 + -18));
	    	}
	    }
        
        //The player inventory offset on the Y axis
        int yOffsetInventory = 130;
        //The Inventory
        for(int y = 0; y < 3; ++y)
        {
        	for(int x = 0; x < 9; ++x)
        	{
        		this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, yOffsetInventory + y * 18 + -18));
        	}
        }
        //The Hotbar
        for(int x = 0; x < 9; ++x)
        {
        	this.addSlot(new Slot(playerInventory, x, 8 + x * 18, yOffsetInventory + 40));
        }
	}
	
	/**
	 * Determines whether supplied player can use this container
	 */
	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return this.bufflonStorge.isUsableByPlayer(playerIn) && this.bufflonEntity.isAlive() && this.bufflonEntity.getDistance(playerIn) < 8.0F;
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
	      if(slot != null && slot.getHasStack())
	      {
	    	  ItemStack itemstack1 = slot.getStack();
	    	  itemstack = itemstack1.copy();
	    	  if(index < (6 * 9) + 2)
	    	  {
	    		  if(!this.mergeItemStack(itemstack1, 9 * 9, this.inventorySlots.size(), true))
	    		  {
	    			  return ItemStack.EMPTY;
	    		  }
	    	  }
	    	  else if(!this.mergeItemStack(itemstack1, 0, 9 * 9, false))
	    	  {
	    		  return ItemStack.EMPTY;
	    	  }

	    	  if(itemstack1.isEmpty())
	    	  {
	    		  slot.putStack(ItemStack.EMPTY);
	    	  }
	    	  else
	    	  {
	    		  slot.onSlotChanged();
	    	  }
	      }

	      return itemstack;
	}
	
	/**
	 * Called when the container is closed.
	 */
	@Override
	public void onContainerClosed(PlayerEntity playerIn)
	{
		super.onContainerClosed(playerIn);
		this.bufflonStorge.closeInventory(playerIn);
	}
	
	/**
	 * @return - The Bufflon Entity this container belongs to
	 */
	public BufflonEntity getBufflonEntity()
    {
        return bufflonEntity;
    }
}