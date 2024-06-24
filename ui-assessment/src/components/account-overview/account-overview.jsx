import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHardHat } from '@fortawesome/free-solid-svg-icons';
import styled from 'styled-components';

import './account-overview.css';
import { Header } from './header/header';
import { Overview } from './overview/overview';

const sizes = {
  smallScreen: '377',
  mediumScreen: '480px'
};

const devices = {
  smallScreen: `(max-width: ${sizes.smallScreen})`,
  mediumScreen: `(max-width: ${sizes.mediumScreen})`,
}


const Button = styled.button``;





export const AccountOverview = ({data}) => {
  console.log(data);

  return (
    <>
      <div className="AccountOverview">
        <Header data={data?.supportContact} />
        <Overview data={data?.salesOverview}/>
        {/* <FontAwesomeIcon icon={faHardHat} /> */}
        {/* Build your components here */}
      </div>
    </>
  )
}

export default AccountOverview;