/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.client.filemanagement;

import java.io.File;

/**
 *
 * @author Bennett.DenBleyker, Gabriel.Maxfield
 */
public interface IFileManager {
    public void saveFile(String path, File f);
    public File getFile(String path);
}
