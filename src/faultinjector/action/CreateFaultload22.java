package faultinjector.action;

import java.util.List;

import faultinjector.entity.Register;

/**
 * This Action class accesses the database and provides the necessary data to display a list of the available registers
 * in new_faultload_3.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Register
 */

public class CreateFaultload22 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private List<Register> registers;

	@Override
	public String execute()
	{
		this.registers = this.getExperimentService().findAllRegisters();

		System.out.println("LOAD REGISTERS-------------------------------");

		for (Register r : this.registers)
		{
			System.out.println("Register ID = " + r.getRegisterId());
			System.out.println("Register NAME = " + r.getName());
			System.out.println();
		}

		return SUCCESS;
	}

	public List<Register> getRegisters()
	{
		return registers;
	}
}
