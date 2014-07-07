/*
 *
 * This file was generated by LLRP Code Generator
 * see http://llrp-toolkit.cvs.sourceforge.net/llrp-toolkit/ for more information
 * Generated on: $utility.getDateNTime();
 *
 */

/*
 *  Copyright (C) 2014 KAIST
 *	@author Janggwan Im <limg00n@kaist.ac.kr>
 * 
 *  Copyright 2007 Pramari, LLC.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
*/
package kr.ac.kaist.resl.ltk.generated;

import org.apache.log4j.Logger;

import org.jdom.Document;
import org.jdom.Element;

import org.llrp.ltk.exceptions.InvalidLLRPMessageException;
import kr.ac.kaist.resl.ltk.generated.messages.*;
import org.llrp.ltk.types.*;

import java.util.HashMap;


/**
 *
 * LLRPMessageFactory generates LLRPMessage objects from LLRP Messages
 * in binary or LTK XML encoding.
 *
 * LLRPMessageFactory detects the message types in a binary or XML message and
 * instantiates the corresponding LTK Java message object, e.g. ADD_ROSPEC.
 * The static factory methods return the abstract LLRPMessage.
 *
 * Example: Input a LLRP message in LTK XML format and output the binary
 * representation:
 *
 * // build JDOM document from file
 * org.jdom.Document doc = new org.jdom.input.SAXBuilder().build(new
 *                                                FileReader(filename));
 * // create LTK-Java object
 * LLRPMessage message = LLRPMessageFactory.createLLRPMessage(doc);
 *
 * // output as a binary message
 * byte[] output = message.encodeBinary();
 *
 *
 *
 * @author Andreas Huebner - andreas@pramari.com
 * @author Christian Floerkemeier - floerkem@mit.edu
 *
 */
public class LLRPMessageFactory {
    /* logger for LLRPMessageFactory */
    private static final Logger logger = Logger.getLogger("LLRPMessageFactory");
    public static final int reservedLength = 3;
    public static final int versionLength = 3;

    /**
     * Generates a LLRPMessage out of the given LLRPBitList.
     *
     * @param bits
     *         LLRPBitList of a LLRPMessage
     * @return appropriate LLRPMessage out of the given LLRPBitList
     *                    or null when Message couldn't be generated
     */
    public static LLRPMessage createLLRPMessage(LLRPBitList bits)
        throws InvalidLLRPMessageException {
        // determine messageType
        Short messageType = new SignedShort(bits.subList(reservedLength +
                    versionLength,
                    SignedShort.length() - (reservedLength + versionLength))).toShort();

        LLRPMessage message = null;

        // construct appropriate message object
        if (messageType == CUSTOM_MESSAGE.TYPENUM.intValue()) {
            message = new CUSTOM_MESSAGE(bits);

            int subtype = ((CUSTOM_MESSAGE) message).getMessageSubtype()
                           .intValue();

            // end custom
        }

        if (messageType == GET_READER_CAPABILITIES.TYPENUM.intValue()) {
            message = new GET_READER_CAPABILITIES(bits);
        }

        if (messageType == GET_READER_CAPABILITIES_RESPONSE.TYPENUM.intValue()) {
            message = new GET_READER_CAPABILITIES_RESPONSE(bits);
        }

        if (messageType == ADD_ROSPEC.TYPENUM.intValue()) {
            message = new ADD_ROSPEC(bits);
        }

        if (messageType == ADD_ROSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new ADD_ROSPEC_RESPONSE(bits);
        }

        if (messageType == DELETE_ROSPEC.TYPENUM.intValue()) {
            message = new DELETE_ROSPEC(bits);
        }

        if (messageType == DELETE_ROSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new DELETE_ROSPEC_RESPONSE(bits);
        }

        if (messageType == START_ROSPEC.TYPENUM.intValue()) {
            message = new START_ROSPEC(bits);
        }

        if (messageType == START_ROSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new START_ROSPEC_RESPONSE(bits);
        }

        if (messageType == STOP_ROSPEC.TYPENUM.intValue()) {
            message = new STOP_ROSPEC(bits);
        }

        if (messageType == STOP_ROSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new STOP_ROSPEC_RESPONSE(bits);
        }

        if (messageType == ENABLE_ROSPEC.TYPENUM.intValue()) {
            message = new ENABLE_ROSPEC(bits);
        }

        if (messageType == ENABLE_ROSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new ENABLE_ROSPEC_RESPONSE(bits);
        }

        if (messageType == DISABLE_ROSPEC.TYPENUM.intValue()) {
            message = new DISABLE_ROSPEC(bits);
        }

        if (messageType == DISABLE_ROSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new DISABLE_ROSPEC_RESPONSE(bits);
        }

        if (messageType == GET_ROSPECS.TYPENUM.intValue()) {
            message = new GET_ROSPECS(bits);
        }

        if (messageType == GET_ROSPECS_RESPONSE.TYPENUM.intValue()) {
            message = new GET_ROSPECS_RESPONSE(bits);
        }

        if (messageType == ADD_ACCESSSPEC.TYPENUM.intValue()) {
            message = new ADD_ACCESSSPEC(bits);
        }

        if (messageType == ADD_ACCESSSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new ADD_ACCESSSPEC_RESPONSE(bits);
        }

        if (messageType == DELETE_ACCESSSPEC.TYPENUM.intValue()) {
            message = new DELETE_ACCESSSPEC(bits);
        }

        if (messageType == DELETE_ACCESSSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new DELETE_ACCESSSPEC_RESPONSE(bits);
        }

        if (messageType == ENABLE_ACCESSSPEC.TYPENUM.intValue()) {
            message = new ENABLE_ACCESSSPEC(bits);
        }

        if (messageType == ENABLE_ACCESSSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new ENABLE_ACCESSSPEC_RESPONSE(bits);
        }

        if (messageType == DISABLE_ACCESSSPEC.TYPENUM.intValue()) {
            message = new DISABLE_ACCESSSPEC(bits);
        }

        if (messageType == DISABLE_ACCESSSPEC_RESPONSE.TYPENUM.intValue()) {
            message = new DISABLE_ACCESSSPEC_RESPONSE(bits);
        }

        if (messageType == GET_ACCESSSPECS.TYPENUM.intValue()) {
            message = new GET_ACCESSSPECS(bits);
        }

        if (messageType == GET_ACCESSSPECS_RESPONSE.TYPENUM.intValue()) {
            message = new GET_ACCESSSPECS_RESPONSE(bits);
        }

        if (messageType == GET_READER_CONFIG.TYPENUM.intValue()) {
            message = new GET_READER_CONFIG(bits);
        }

        if (messageType == GET_READER_CONFIG_RESPONSE.TYPENUM.intValue()) {
            message = new GET_READER_CONFIG_RESPONSE(bits);
        }

        if (messageType == SET_READER_CONFIG.TYPENUM.intValue()) {
            message = new SET_READER_CONFIG(bits);
        }

        if (messageType == SET_READER_CONFIG_RESPONSE.TYPENUM.intValue()) {
            message = new SET_READER_CONFIG_RESPONSE(bits);
        }

        if (messageType == CLOSE_CONNECTION.TYPENUM.intValue()) {
            message = new CLOSE_CONNECTION(bits);
        }

        if (messageType == CLOSE_CONNECTION_RESPONSE.TYPENUM.intValue()) {
            message = new CLOSE_CONNECTION_RESPONSE(bits);
        }

        if (messageType == GET_REPORT.TYPENUM.intValue()) {
            message = new GET_REPORT(bits);
        }

        if (messageType == RO_ACCESS_REPORT.TYPENUM.intValue()) {
            message = new RO_ACCESS_REPORT(bits);
        }

        if (messageType == KEEPALIVE.TYPENUM.intValue()) {
            message = new KEEPALIVE(bits);
        }

        if (messageType == KEEPALIVE_ACK.TYPENUM.intValue()) {
            message = new KEEPALIVE_ACK(bits);
        }

        if (messageType == READER_EVENT_NOTIFICATION.TYPENUM.intValue()) {
            message = new READER_EVENT_NOTIFICATION(bits);
        }

        if (messageType == ENABLE_EVENTS_AND_REPORTS.TYPENUM.intValue()) {
            message = new ENABLE_EVENTS_AND_REPORTS(bits);
        }

        if (messageType == ERROR_MESSAGE.TYPENUM.intValue()) {
            message = new ERROR_MESSAGE(bits);
        }

        // check whether the message type exists
        if (message == null) {
            throw new InvalidLLRPMessageException("The message type (\"" +
                messageType +
                "\") specified in the binary LLRP message is not known.");
        } else {
            return message;
        }
    }

    /**
     * Generates a LLRPMessage out of the given Byte Array.
     *
     * @param byteArray
     *         byte[] of a LLRPMessage
     * @return appropriate LLRPMessage out of the given byte[]
     *                    or null when Message couldn't be generated
     */
    public static LLRPMessage createLLRPMessage(byte[] byteArray)
        throws InvalidLLRPMessageException {
        LLRPBitList bits = new LLRPBitList(byteArray);

        return createLLRPMessage(bits);
    }

    public static LLRPMessage createLLRPMessage(Document document)
        throws InvalidLLRPMessageException {
        // determine messageType
        Element root = document.getRootElement();
        String className = root.getName();
        logger.debug("Root element of input document is: " + className);

        // construct appropriate message object
        LLRPMessage message = null;

        if (className.equals("CUSTOM_MESSAGE")) {
            message = new CUSTOM_MESSAGE(document);
        }

        if (className.equals("GET_READER_CAPABILITIES")) {
            message = new GET_READER_CAPABILITIES(document);
        }

        if (className.equals("GET_READER_CAPABILITIES_RESPONSE")) {
            message = new GET_READER_CAPABILITIES_RESPONSE(document);
        }

        if (className.equals("ADD_ROSPEC")) {
            message = new ADD_ROSPEC(document);
        }

        if (className.equals("ADD_ROSPEC_RESPONSE")) {
            message = new ADD_ROSPEC_RESPONSE(document);
        }

        if (className.equals("DELETE_ROSPEC")) {
            message = new DELETE_ROSPEC(document);
        }

        if (className.equals("DELETE_ROSPEC_RESPONSE")) {
            message = new DELETE_ROSPEC_RESPONSE(document);
        }

        if (className.equals("START_ROSPEC")) {
            message = new START_ROSPEC(document);
        }

        if (className.equals("START_ROSPEC_RESPONSE")) {
            message = new START_ROSPEC_RESPONSE(document);
        }

        if (className.equals("STOP_ROSPEC")) {
            message = new STOP_ROSPEC(document);
        }

        if (className.equals("STOP_ROSPEC_RESPONSE")) {
            message = new STOP_ROSPEC_RESPONSE(document);
        }

        if (className.equals("ENABLE_ROSPEC")) {
            message = new ENABLE_ROSPEC(document);
        }

        if (className.equals("ENABLE_ROSPEC_RESPONSE")) {
            message = new ENABLE_ROSPEC_RESPONSE(document);
        }

        if (className.equals("DISABLE_ROSPEC")) {
            message = new DISABLE_ROSPEC(document);
        }

        if (className.equals("DISABLE_ROSPEC_RESPONSE")) {
            message = new DISABLE_ROSPEC_RESPONSE(document);
        }

        if (className.equals("GET_ROSPECS")) {
            message = new GET_ROSPECS(document);
        }

        if (className.equals("GET_ROSPECS_RESPONSE")) {
            message = new GET_ROSPECS_RESPONSE(document);
        }

        if (className.equals("ADD_ACCESSSPEC")) {
            message = new ADD_ACCESSSPEC(document);
        }

        if (className.equals("ADD_ACCESSSPEC_RESPONSE")) {
            message = new ADD_ACCESSSPEC_RESPONSE(document);
        }

        if (className.equals("DELETE_ACCESSSPEC")) {
            message = new DELETE_ACCESSSPEC(document);
        }

        if (className.equals("DELETE_ACCESSSPEC_RESPONSE")) {
            message = new DELETE_ACCESSSPEC_RESPONSE(document);
        }

        if (className.equals("ENABLE_ACCESSSPEC")) {
            message = new ENABLE_ACCESSSPEC(document);
        }

        if (className.equals("ENABLE_ACCESSSPEC_RESPONSE")) {
            message = new ENABLE_ACCESSSPEC_RESPONSE(document);
        }

        if (className.equals("DISABLE_ACCESSSPEC")) {
            message = new DISABLE_ACCESSSPEC(document);
        }

        if (className.equals("DISABLE_ACCESSSPEC_RESPONSE")) {
            message = new DISABLE_ACCESSSPEC_RESPONSE(document);
        }

        if (className.equals("GET_ACCESSSPECS")) {
            message = new GET_ACCESSSPECS(document);
        }

        if (className.equals("GET_ACCESSSPECS_RESPONSE")) {
            message = new GET_ACCESSSPECS_RESPONSE(document);
        }

        if (className.equals("GET_READER_CONFIG")) {
            message = new GET_READER_CONFIG(document);
        }

        if (className.equals("GET_READER_CONFIG_RESPONSE")) {
            message = new GET_READER_CONFIG_RESPONSE(document);
        }

        if (className.equals("SET_READER_CONFIG")) {
            message = new SET_READER_CONFIG(document);
        }

        if (className.equals("SET_READER_CONFIG_RESPONSE")) {
            message = new SET_READER_CONFIG_RESPONSE(document);
        }

        if (className.equals("CLOSE_CONNECTION")) {
            message = new CLOSE_CONNECTION(document);
        }

        if (className.equals("CLOSE_CONNECTION_RESPONSE")) {
            message = new CLOSE_CONNECTION_RESPONSE(document);
        }

        if (className.equals("GET_REPORT")) {
            message = new GET_REPORT(document);
        }

        if (className.equals("RO_ACCESS_REPORT")) {
            message = new RO_ACCESS_REPORT(document);
        }

        if (className.equals("KEEPALIVE")) {
            message = new KEEPALIVE(document);
        }

        if (className.equals("KEEPALIVE_ACK")) {
            message = new KEEPALIVE_ACK(document);
        }

        if (className.equals("READER_EVENT_NOTIFICATION")) {
            message = new READER_EVENT_NOTIFICATION(document);
        }

        if (className.equals("ENABLE_EVENTS_AND_REPORTS")) {
            message = new ENABLE_EVENTS_AND_REPORTS(document);
        }

        if (className.equals("ERROR_MESSAGE")) {
            message = new ERROR_MESSAGE(document);
        }

        // check whether the message type exists
        if (message == null) {
            throw new InvalidLLRPMessageException("The message type (\"" +
                className +
                "\") specified in the LTK-XML message is not known.");
        } else {
            return message;
        }
    }
}