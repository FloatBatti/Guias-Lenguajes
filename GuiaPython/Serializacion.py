from SistemaHospital.Models.Paciente import Paciente

def serializarPaciente(paciente:Paciente):
    
    diccConsultorio={}
    diccDoctor={}
    diccTurno={}
    diccPaciente={}
    
    #Consultorio
    diccConsultorio["_numero"] = paciente.gerTurno().getConsultorio().getNumero()
    diccConsultorio["_estado"] = paciente.gerTurno().getConsultorio().getEstado()
    
    #Doctor
    diccDoctor["_nombre"] = paciente.gerTurno().getDoctor().getNombre()
    diccDoctor["_dni"] = paciente.gerTurno().getDoctor().getDni()
    diccDoctor["_telefono"] = paciente.gerTurno().getDoctor().getTelefono()
    diccDoctor["_mail"] = paciente.gerTurno().getDoctor().getMail()
    diccDoctor["_especializacion"] = paciente.gerTurno().getDoctor().getEspecializacion()
    
    #Turno
    diccTurno["_fecha"] = paciente.gerTurno().getFecha()
    diccTurno["_doctor"] = diccDoctor
    diccTurno["_consultorio"] = diccConsultorio
    
    #Paciente
    diccPaciente["_nombre"] = paciente.getNombre()
    diccPaciente["_dni"] = paciente.getDni()
    diccPaciente["_telefono"] = paciente.getTelefono()
    diccPaciente["_mail"] = paciente.getMail()
    diccPaciente["_obraSocial"] = paciente.getObraSocial()
    diccPaciente["_turno"] = diccTurno
    
    return diccPaciente